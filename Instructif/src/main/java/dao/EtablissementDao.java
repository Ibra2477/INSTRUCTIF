/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Etablissement ;

/**
 *
 * @author imarcil
 */
public class EtablissementDao {
    public void create(Etablissement etab) {
        JpaUtil.obtenirContextePersistance().persist(etab);}
    
     
    public void delete(Etablissement etab) {
        JpaUtil.obtenirContextePersistance().remove(etab);
    }
    
    public void update(Etablissement etab) {
        JpaUtil.obtenirContextePersistance().merge(etab);
    }
    
    public Etablissement findById(String code){
        return JpaUtil.obtenirContextePersistance().find(Etablissement.class, code);
    }
    
    
    }
    

