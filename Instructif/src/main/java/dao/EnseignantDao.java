/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Enseignant;

/**
 *
 * @author imarcil
 */
public class EnseignantDao {
    
    public void create(Enseignant enseignant) {
        JpaUtil.obtenirContextePersistance().persist(enseignant);}
    public void delete(Enseignant enseignant) {
        JpaUtil.obtenirContextePersistance().remove(enseignant);
    }
    public void update(Enseignant enseignant) {
        JpaUtil.obtenirContextePersistance().merge(enseignant);
    }
    
}


    
    
     
    
    
    
    

