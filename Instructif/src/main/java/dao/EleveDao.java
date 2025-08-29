/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Eleve;

/**
 *
 * @author imarcil
 */
public class EleveDao {
    public void create(Eleve eleve) {
        JpaUtil.obtenirContextePersistance().persist(eleve);}
    
     
    public void delete(Eleve eleve) {
        JpaUtil.obtenirContextePersistance().remove(eleve);
    }
    
    public Eleve update(Eleve eleve) {
        return JpaUtil.obtenirContextePersistance().merge(eleve);
    }
     public Eleve findById(Long id) {
    return JpaUtil.obtenirContextePersistance().find(Eleve.class, id);
}
     public Eleve findlogins(String mail,String mdp)
    {
        String jpql = "select c from Eleve c where c.mail = :mail and c.mdp = :mdp";
        EntityManager em = JpaUtil.obtenirContextePersistance();
        Query query = em.createQuery(jpql);
        query.setParameter("mail", mail); // Remplacer le paramètre dans la requete 
        query.setParameter("mdp", mdp); 
        try {
            return (Eleve) query.getSingleResult();
        } catch (Exception e) {
            return null; // Si aucune correspondance n'est trouvée, retourne null
        }
    }
    
}
