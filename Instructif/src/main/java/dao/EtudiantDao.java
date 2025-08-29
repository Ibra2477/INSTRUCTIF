/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Etudiant;

/**
 *
 * @author imarcil
 */
public class EtudiantDao {
    
    public void create(Etudiant etudiant) {
        JpaUtil.obtenirContextePersistance().persist(etudiant);}
    public void delete(Etudiant etudiant) {
        JpaUtil.obtenirContextePersistance().remove(etudiant);
    }
    public Etudiant  update(Etudiant etudiant) {
        return JpaUtil.obtenirContextePersistance().merge(etudiant);
    }
    
     public Etudiant findById(Long id){
        return JpaUtil.obtenirContextePersistance().find(Etudiant .class, id);
    }
}


    
    
     
    
    
    
    

