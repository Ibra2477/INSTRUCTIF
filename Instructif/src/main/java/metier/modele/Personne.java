package metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imarcil
 */
@MappedSuperclass 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
    
    protected String nom;
    protected String prenom;
    @Column(unique = true)
    protected String mail;
    protected String mdp;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    public Personne(String nom, String prenom, String mail, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
    }

    public Personne() {
    }

    public abstract Long getId();

    public abstract void setId(Long id) ;

    public abstract String getNom();

    public abstract void setNom(String nom) ;

    public abstract  String getPrenom() ;

    public abstract void setPrenom(String prenom);

    public abstract String getMail() ;

    public abstract  void setMail(String mail);

    public abstract String getMdp() ;

    public abstract  void setMdp(String mdp) ;
    
    
    
}
