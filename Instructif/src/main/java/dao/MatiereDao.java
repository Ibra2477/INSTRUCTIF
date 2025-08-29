/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import metier.modele.Etablissement;
import metier.modele.Matiere;

/**
 *
 * @author imarcil
 */
public class MatiereDao {
     public void create(Matiere matiere) {
        JpaUtil.obtenirContextePersistance().persist(matiere);}
    public void delete(Matiere matiere) {
        JpaUtil.obtenirContextePersistance().remove(matiere);
    }
    public void update(Matiere matiere) {
        JpaUtil.obtenirContextePersistance().merge(matiere);
    }
    public Matiere findById(Integer id){
        return JpaUtil.obtenirContextePersistance().find(Matiere.class, id);
    }
    public List<Matiere> GetListeMatieresDao() {
       List<Matiere> listeMatieres  ;
       String jpql = "select m from Matiere m order by m.nomMatiere ASC";
       try{
            EntityManager em = JpaUtil.obtenirContextePersistance();
            TypedQuery<Matiere> query = em.createQuery(jpql, Matiere.class);
            
            listeMatieres  = query.getResultList();
        }
        catch(Exception e){
            listeMatieres = null;
        }
        return listeMatieres;
    }

}
