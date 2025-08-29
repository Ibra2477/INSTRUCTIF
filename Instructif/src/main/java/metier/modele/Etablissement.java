/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author imarcil
 */
@Entity
public class Etablissement implements Serializable {
    
    @Id
    private String code;
    private String nom;
    private String secteur;
    private String code_insee_commune;
    private String nom_commune;
    private String code_depart;
    private String departement;
    private String academie;
    private String ips;

    public Etablissement(String code) {
        this.code = code;
    }
    
    public Etablissement(String code, String nom, String secteur, String code_insee_commune, String nom_commune, String code_depart, String departement, String academie, String ips) {
        this.code = code;
        this.nom = nom;
        this.secteur = secteur;
        this.code_insee_commune = code_insee_commune;
        this.nom_commune = nom_commune;
        this.code_depart = code_depart;
        this.departement = departement;
        this.academie = academie;
        this.ips = ips;
    }

    public Etablissement() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public String getSecteur() {
        return secteur;
    }

    public String getCode_insee_commune() {
        return code_insee_commune;
    }

    public String getNom_commune() {
        return nom_commune;
    }

    public String getCode_depart() {
        return code_depart;
    }

    public String getDepartement() {
        return departement;
    }

    public String getAcademie() {
        return academie;
    }

    public String getIps() {
        return ips;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public void setCode_insee_commune(String code_insee_commune) {
        this.code_insee_commune = code_insee_commune;
    }

    public void setNom_commune(String nom_commune) {
        this.nom_commune = nom_commune;
    }

    public void setCode_depart(String code_depart) {
        this.code_depart = code_depart;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public void setAcademie(String academie) {
        this.academie = academie;
    }

        public void setIps(String ips) {
        this.ips = ips;
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
        final Etablissement other = (Etablissement) obj;
        if (this.code_depart != other.code_depart) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.secteur, other.secteur)) {
            return false;
        }
        if (!Objects.equals(this.nom_commune, other.nom_commune)) {
            return false;
        }
        if (!Objects.equals(this.departement, other.departement)) {
            return false;
        }
        if (!Objects.equals(this.academie, other.academie)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.code_insee_commune, other.code_insee_commune)) {
            return false;
        }
        if (!Objects.equals(this.ips, other.ips)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etablissement{" + "code=" + code + ", nom=" + nom + ", secteur=" + secteur + ", code_insee_commune=" + code_insee_commune + ", nom_commune=" + nom_commune + ", code_depart=" + code_depart + ", departement=" + departement + ", academie=" + academie + ", ips=" + ips + '}';
    }
    
    
           
    
}
