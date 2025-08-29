package metier.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imarcil
 */
@Entity
public class Eleve extends Personne {
    
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private Integer  classe;
    @ManyToOne
    private Etablissement etab;
    @OneToMany(mappedBy="eleve")
    private List<DemandeSoutien> listeDemandeSoutien;
     
    public Eleve() {
    }



    public Eleve(String nom, String prenom, String mail, String mdp,Date dateNaissance, Integer classe) {
        super(nom, prenom, mail, mdp);
        this.dateNaissance = dateNaissance;
        this.classe = classe;
       
        this.listeDemandeSoutien =   new ArrayList<>();
    }

    public List<DemandeSoutien> getListeDemandeSoutien() {
        return listeDemandeSoutien;
    }

    public void setListeDemandeSoutien(List<DemandeSoutien> listeDemandeSoutien) {
        this.listeDemandeSoutien = listeDemandeSoutien;
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
    
    public Integer getClasse() {
        return classe;
    }
    @Override 
    public Long getId() {
        return id;
    }
    
    public Etablissement getEtab() {
        return etab;
    }
    @Override 
    public void setId(Long id) {
        this.id = id;
    }

    public void setEtab(Etablissement etab) {
        this.etab = etab;
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

    public void setClasse(Integer classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Eleve{" + "dateNaissance=" + dateNaissance + ", classe=" + classe + ", etab=" + etab + ", listeDemandeSoutien=" + listeDemandeSoutien + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.dateNaissance);
        hash = 59 * hash + Objects.hashCode(this.classe);
        hash = 59 * hash + Objects.hashCode(this.etab);
        hash = 59 * hash + Objects.hashCode(this.listeDemandeSoutien);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Eleve other = (Eleve) obj;
        if (!Objects.equals(this.dateNaissance, other.dateNaissance)) {
            return false;
        }
        if (!Objects.equals(this.classe, other.classe)) {
            return false;
        }
        if (!Objects.equals(this.etab, other.etab)) {
            return false;
        }
        if (!Objects.equals(this.listeDemandeSoutien, other.listeDemandeSoutien)) {
            return false;
        }
        return true;
    }

  
}
