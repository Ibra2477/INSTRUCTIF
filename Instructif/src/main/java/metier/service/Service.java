/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.DemandeSoutienDao;
import util.EducNetApi;
import dao.EleveDao;
import dao.EnseignantDao;
import dao.EtablissementDao;
import dao.IntervenantDao;
import dao.JpaUtil;
import dao.MatiereDao;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import metier.modele.Eleve;
import metier.modele.Etablissement;
import metier.modele.Matiere;
import metier.modele.DemandeSoutien;
import metier.modele.Enseignant;
import metier.modele.Intervenant;
import util.Message;

/**
 *
 * @author imarcil
 */
public class Service {
    
    //Ajouter service d'authentification : verfier que c'est bon et savoir QUI est connécté
    //Service qui liste les matieres pour qu'elles puissent etre selectionné par l'eleve
    //Service a ajouter : L'intervenant doit voir ses interventions : service afficher l'intervention qu'il doit effectuer. 
     public Boolean inscrireEleve (Eleve eleve, String code_etab){
         Boolean res;
         Message message= new Message();
         EleveDao elevedao = new EleveDao();
         EtablissementDao etabdao = new EtablissementDao();
       
                 try{
             JpaUtil.creerContextePersistance();
             JpaUtil.ouvrirTransaction();
             elevedao.create(eleve);
             //remplir les attributs de l'etab à partir de son code 
                 EducNetApi api = new EducNetApi();
                 List<String> result = api.getInformationEtablissement(code_etab);
                if (result != null) {
                        String uai = result.get(0);
                        String nom = result.get(1);
                        String secteur = result.get(2);
                        String codeCommune = result.get(3);
                        String nomCommune = result.get(4);
                        String codeDepartement = result.get(5);
                        String nomDepartement = result.get(6);
                        String academie = result.get(7);
                        String ips = result.get(8);
                        Etablissement monetab= new Etablissement(uai,nom,secteur,codeCommune,nomCommune,codeDepartement,nomDepartement,academie,ips);
                        eleve.setEtab(monetab);
                         elevedao.update(eleve);
             //si l'etablissement n'est pas dans la base de donné alors je l'ajoute 
             //Avant de l'ajouter, je rempli les attributs de l'etab (grace a educNetApi) à partir du code fourni par l'elève
             if (etabdao.findById(code_etab)==null){
                 etabdao.create(monetab);
                }
                 
             }
             
             JpaUtil.validerTransaction();
             message.envoyerMail("monmail@gmail.com",eleve.getMail(),"Bien vu l'inscription","Eh mercééé" + eleve.getEtab().toString());
             res=true;
         }
         catch(Exception ex ){
             res = false;
             ex.printStackTrace();
             JpaUtil.annulerTransaction();
             message.envoyerMail("monmail@gmail.com",eleve.getMail(),"échec d'inscription","Votre inscription a échouééééééé");
             
         }
         finally{
             JpaUtil.fermerContextePersistance();

         }
         return res;
     }
    public Boolean creerDemandeSoutien(Eleve eleve,String description,Integer idMatiere){
         //chercher un intervenant
         Boolean res;
         Message message= new Message();
         DemandeSoutienDao demandeDao = new DemandeSoutienDao();
         EleveDao eleveDao = new EleveDao();
         MatiereDao matDao = new MatiereDao();
         IntervenantDao intervenantDao = new IntervenantDao();
        
 
         try{
             JpaUtil.creerContextePersistance();
             JpaUtil.ouvrirTransaction();
             Matiere matiere = matDao.findById(idMatiere);
             LocalTime time= LocalTime.now();
             System.out.println("hiii; "+ time);
             DemandeSoutien demande = new DemandeSoutien(description,matiere,eleve,time);
             demandeDao.create(demande);
             //ajouter la demande à la liste des demandes de l'eleve
             List<DemandeSoutien> temp_liste= eleve.getListeDemandeSoutien();
             temp_liste.add(demande);
             eleve.setListeDemandeSoutien(temp_liste);
             eleveDao.update(eleve);
             //merge eleve
             //Générer le lien de la visio
             String lien_visio="a creer";
             demande.setLien_visio(lien_visio);
             //Chercher l'intervenant adequat
             // Pas deja en visio + niveau de competence recquis pour repondre
             //le moins d'interventions
             Intervenant intervenant = intervenantDao.findIntervenant(eleve.getClasse());
             demande.setIntervenant(intervenant);
             demande.setEtat(1); //soutient en cours
             intervenant.setDispo(false);
             intervenant.setNbSoutien(intervenant.getNbSoutien()+1);
             demandeDao.update(demande);
             intervenantDao.update(intervenant);
             JpaUtil.validerTransaction();
            
             res=true;
         }
         catch(Exception ex ){
             res = false;
             ex.printStackTrace();
             JpaUtil.annulerTransaction();
                          
         }
         finally{
             JpaUtil.fermerContextePersistance();

         }
         return res;
     }

      public Boolean peuplerDataBase(){
         Boolean res;
         EnseignantDao enseignantDao = new EnseignantDao();
         MatiereDao matDao = new MatiereDao();
         try{
             JpaUtil.creerContextePersistance();
             JpaUtil.ouvrirTransaction();
             Enseignant inter1= new Enseignant("Supérieur",612345678L, 6, 2,"Mathieu", "Maranzana","maranzana@gmail.com", "monmdp") ;
             enseignantDao.create(inter1);
             Enseignant inter2 = new Enseignant("Lycéé",698765432L, 6, 2,"Un", "Prof","unprof@gmail.com", "monmdp") ;        
             enseignantDao.create(inter2);
             Matiere mat1 = new Matiere(2,"Francais");
             Matiere mat2 = new Matiere(3,"Maths");
             Matiere mat3 = new Matiere(4,"Physique");
             matDao.create(mat1);
             matDao.create(mat2);
             matDao.create(mat3);
             JpaUtil.validerTransaction();
             
             res=true;
         }
         catch(Exception ex ){
             res = false;
             ex.printStackTrace();
             JpaUtil.annulerTransaction();
             
             
         }
         finally{
             JpaUtil.fermerContextePersistance();

         }
         return res;
     }

 public List<Matiere> getListeMatieres() {
        List<Matiere> listeMatieres = new ArrayList<>();

        try {
            JpaUtil.creerContextePersistance();

            MatiereDao matiereDao = new MatiereDao();
            listeMatieres = matiereDao.GetListeMatieresDao();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.fermerContextePersistance(); // Ferme l'EntityManager
        }
        return listeMatieres;
    }
      
      

       public Etablissement trouverEtablissementbyId(String code)
            {  
                JpaUtil.creerContextePersistance(); // Ouvrir le contexte
                Etablissement e= new EtablissementDao().findById(code);
                 JpaUtil.fermerContextePersistance(); // Fermer le contexte
                return e;
            }  
      
   
        public Eleve trouverElevebyId(Long id)
            {  
                JpaUtil.creerContextePersistance(); // Ouvrir le contexte
                Eleve e= new EleveDao().findById(id);
                 JpaUtil.fermerContextePersistance(); // Fermer le contexte
                return e;
            }  
        
    public boolean authentification(String mail, String mdp) throws Exception
            {
                  JpaUtil.creerContextePersistance(); // Ouvrir le contexte
                    
                    EleveDao eleve = new EleveDao();
                       Boolean etat= false;
                     Eleve   eleve_authentifie=eleve.findlogins(mail, mdp);

                    if(eleve_authentifie==null){
                       System.out.println("Echec de l'authentification: Veuillez vérifiez le mail et le mdp");
             
                   }
                    else{
                       
                               JpaUtil.fermerContextePersistance(); // Fermer le contexte
                        System.out.println("Authentification réussie : Nom de l'éléve : "+eleve_authentifie.getNom()+" "+eleve_authentifie.getPrenom()+"  / ID : "+eleve_authentifie.getId());
                        etat=true;
                      }
                    return etat;
            }
    
 
    
            public boolean terminerSoutien(Long idDemande) {
            boolean res = false;

            try {
                JpaUtil.creerContextePersistance();
                JpaUtil.ouvrirTransaction();
                IntervenantDao intervenantDao= new IntervenantDao();
                DemandeSoutienDao demandeDao = new DemandeSoutienDao();
                DemandeSoutien demande = demandeDao.findById(idDemande);
                    ///mettre à jour la dispo intervenant
                    demande.getIntervenant().setDispo(true);
                    intervenantDao.update(demande.getIntervenant());
                if (demande != null) {

                    demande.setEtat(2); // Met l'état à "visio terminée"
                    demandeDao.update(demande); // Enregistre les modifs

                    JpaUtil.validerTransaction();
                    System.out.println("État de la demande mis à jour à 'terminé' (2)");
                    res = true;
                } else {
                    System.out.println("Demande introuvable.");
                    JpaUtil.annulerTransaction();
                }

            } catch (Exception e) {
                JpaUtil.annulerTransaction();
                e.printStackTrace();
            } finally {
                JpaUtil.fermerContextePersistance();
            }

            return res;
            }
                     
     public long calculer_nbre_soutien(Etablissement monetab){
              JpaUtil.creerContextePersistance(); // Ouvrir le contexte
                    
                    DemandeSoutienDao demande = new DemandeSoutienDao();
                       
                        long dureemoyenne= demande.count_nbre_soutien(monetab);
                    
                               JpaUtil.fermerContextePersistance(); // Fermer le contexte
                        System.out.println(" Pour l'étab:  "+monetab.getNom()+"  / nombre de soutien : "+dureemoyenne);
                        
         
                    return dureemoyenne;
     }   
            
            public Long calculer_duree_moyenne(Etablissement etab){
                      JpaUtil.creerContextePersistance(); // Ouvrir le contexte

         DemandeSoutienDao demandedao=new DemandeSoutienDao();
         Long duree =demandedao.calculer_duree_moyenne(etab);
                               JpaUtil.fermerContextePersistance(); // Fermer le contexte

         System.out.println("duree  "+duree);
         
         return(duree);
     }
            
      }
    