/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.DemandeSoutien;
import metier.modele.Etablissement;

/**
 *
 * @author imarcil
 */
public class DemandeSoutienDao {
    public void create(DemandeSoutien demandesoutien) {
        JpaUtil.obtenirContextePersistance().persist(demandesoutien);}
    public void delete(DemandeSoutien demandesoutien) {
        JpaUtil.obtenirContextePersistance().remove(demandesoutien);
    }
    public void update(DemandeSoutien demandesoutien) {
        JpaUtil.obtenirContextePersistance().merge(demandesoutien);
    }  

    public DemandeSoutien findById(Long id) {
         return JpaUtil.obtenirContextePersistance().find(DemandeSoutien.class, id);
    }
      public long count_nbre_soutien(Etablissement monetab){
      String jpql = "SELECT COUNT(s) FROM DemandeSoutien s WHERE s.eleve.etab = :monetab";
        EntityManager em = JpaUtil.obtenirContextePersistance();
        Query query = em.createQuery(jpql);
        query.setParameter("monetab", monetab); // Remplacer le paramètre dans la requete 
        try {
            return (long) query.getSingleResult();
        } catch (Exception e) {
            return 0; // Si aucune correspondance n'est trouvée, retourne null
        }
    }
     public Long calculer_duree_moyenne(Etablissement etab) {
    String jpql = "SELECT d FROM DemandeSoutien d WHERE d.eleve.etab = :etab";
    EntityManager em = JpaUtil.obtenirContextePersistance();
    Query query = em.createQuery(jpql);
    query.setParameter("etab", etab);

    try {
        List<DemandeSoutien> demandes = query.getResultList();

        if (demandes.isEmpty()) return null;

        long totalMinutes = 0;
        int count = 0;

        for (DemandeSoutien d : demandes) {
            LocalTime debut = d.getDebut();
            LocalTime fin = d.getFin();

            if (debut != null && fin != null) {
                long duree = Duration.between(debut, fin).toMinutes();

                // Gérer les cas où l'heure de fin est avant celle de début (ex : minuit passé)
                if (duree < 0) {
                    duree += 24 * 60;
                }

                totalMinutes += duree;
                count++;
            }
        }

        return count > 0 ? totalMinutes / count : null;

    } catch (Exception e) {
        e.printStackTrace(); // Pour log si besoin
        return null;
    }
}

      
}
