/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Autre;

/**
 *
 * @author imarcil
 */
public class AutreDao {
    
    public void create(Autre autre) {
        JpaUtil.obtenirContextePersistance().persist(autre);}
    public void delete(Autre autre) {
        JpaUtil.obtenirContextePersistance().remove(autre);
    }
    public Autre  update(Autre autre) {
        return JpaUtil.obtenirContextePersistance().merge(autre);
    }
    
     public Autre findById(Long id){
        return JpaUtil.obtenirContextePersistance().find(Autre .class, id);
    }
}


    
    
     
    
    
    
    

