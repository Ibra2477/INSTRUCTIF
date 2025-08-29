/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import javax.persistence.Entity;

/**
 *
 * @author imarcil
 */
@Entity
public class Etudiant extends Intervenant {
    private String univ;
    private String specialite;
    
    //Constructeurs

    public Etudiant() {
    }

    public Etudiant(String specialite,String univ, Long tel, Integer niveaumin, Integer niveaumax, String nom, String prenom, String mail, String mdp) {
        super(tel, niveaumin, niveaumax, nom, prenom, mail, mdp);
        this.univ = univ;
        this.specialite = specialite;
    }
     //getters et setters 

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

   
    @Override
    public Long getTel() {
        return tel;
    }
    @Override
    public Integer getNiveaumin() {
        return niveaumin;
    }
    @Override
    public Integer getNiveaumax() {
        return niveaumax;
    }
    @Override
    public Integer getNbSoutien() {
        return nbSoutien;
    }
    @Override
    public Boolean getDispo() {
        return disponible;
    }
    @Override
    public String getNom() {
        return nom;
    }
    @Override
    public String getPrenom() {
        return prenom;
    }
    @Override
    public String getMail() {
        return mail;
    }
    @Override
    public String getMdp() {
        return mdp;
    }
    @Override
    public Long getId() {
        return id;
    }

    
    @Override
    public void setTel(Long tel) {
        this.tel = tel;
    }
    @Override
    public void setNiveaumin(Integer niveaumin) {
        this.niveaumin = niveaumin;
    }   
    @Override
    public void setNiveaumax(Integer niveaumax) {
        this.niveaumax = niveaumax;
    }
    @Override
    public void setNbSoutien(Integer nbSoutien) {
        this.nbSoutien = nbSoutien;
    }
    @Override
    public void setDispo(Boolean disponible) {
        this.disponible = disponible;
    }
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }
    @Override
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    

}