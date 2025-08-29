/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author imarcil
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Intervenant;

/**
 *
 * @author imarcil
 */
public class IntervenantDao {
    
    public void create(Intervenant intervenant) {
        JpaUtil.obtenirContextePersistance().persist(intervenant);}
    public void delete(Intervenant intervenant) {
        JpaUtil.obtenirContextePersistance().remove(intervenant);
    }
    public void update(Intervenant intervenant) {
        JpaUtil.obtenirContextePersistance().merge(intervenant);
    }
    
    
    
    public Intervenant findIntervenant(Integer classe)
    {
        String jpql = "select i from Intervenant i where i.disponible = true "
                + "and i.niveaumin >= :classe and i.niveaumax <= :classe"
                +   " order by i.nbSoutien asc"; // Trier par nbSoutien croissant;
        
        EntityManager em = JpaUtil.obtenirContextePersistance();
        Query query = em.createQuery(jpql);
        
        query.setParameter("classe",classe); 
        // Limiter le résultat à un seul intervenant (celui avec le moins de soutiens)
        query.setMaxResults(1); // On ne prend que le premier résultat trié
        try {
            // Obtenir le premier intervenant (celui avec le moins de soutiens)
            return (Intervenant) query.getSingleResult();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        throw ex; // Tu peux personnaliser le traitement d'erreur
        } 
    }
    

}
    
    
