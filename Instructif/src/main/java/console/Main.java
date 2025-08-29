package console;

import dao.JpaUtil;
import java.util.Date;
import java.util.List;
import metier.modele.DemandeSoutien;
import metier.modele.Eleve;
import metier.modele.Etablissement;
import metier.service.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imarcil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here 
        JpaUtil.creerFabriquePersistance();
        Service service = new Service();
        service.peuplerDataBase();
        Eleve e1 = new Eleve("Marcil","Isma","ismail.marcil@gmail.com","mdp",new Date(),5); 
        Eleve e2 = new Eleve("Guedira","jade","jade.guedira@gmail.com","mdp12",new Date(12,9,2004),5);
        service.inscrireEleve(e1,"0692155T");
        service.inscrireEleve(e2,"0692155T");
        service.authentification("jade.guedira@gmail.com", "mdp12");
        
        service.creerDemandeSoutien(e2,"j'ai besoin d'aide je ne sais pas parler français",2);

        service.authentification("ismail.marcil@gmail.com", "haha");
        
        
        service.terminerSoutien(5L);
         Etablissement etab=service.trouverEtablissementbyId("0692155T");
        service.calculer_duree_moyenne(etab);
        service.calculer_nbre_soutien(etab);
        JpaUtil.fermerFabriquePersistance();
    }
   
    
}
