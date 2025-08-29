/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author imarcil
 */
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)

public abstract class Intervenant extends Personne{
    
     @Column(unique = true)
    protected  Long tel;
    //Les niveaux vont de la 6ie a la terminale, 6 pour 6eme 1 pour prmiere et 0 pour la terminale 
    protected  Integer niveaumin;
    protected  Integer niveaumax;
    protected Integer nbSoutien;
    protected Boolean disponible; 
    
    
    //Constructeurs 
    public Intervenant() {
    }

    public Intervenant(Long tel, Integer niveaumin, Integer niveaumax, String nom, String prenom, String mail, String mdp) {
        super(nom, prenom, mail, mdp);
        this.tel = tel;
        this.niveaumin = niveaumin;
        this.niveaumax = niveaumax;
        this.nbSoutien = 0;
        this.disponible = true;
    }
    
    
    //Getters setters
    

    public abstract void setTel(Long tel);

   
    public abstract  Long getId() ;

    public abstract Long getTel();

    public abstract Integer getNiveaumin() ;

    public abstract Integer getNiveaumax() ;

    public abstract void setNiveaumin(Integer niveaumin);

    public abstract void setNiveaumax(Integer niveaumax) ;
    
    public abstract void setNbSoutien(Integer nb);
    
    public abstract void setDispo(Boolean dispo);
    
    public abstract Integer getNbSoutien();
    
    public abstract Boolean getDispo();
    

   

   

  
    
    
    
}
