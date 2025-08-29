/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author imarcil
 */
@Entity
public class DemandeSoutien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Integer etat;
    private Matiere matiere;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_soutien;
    @ManyToOne
    private Eleve eleve;
    
    private String lien_visio;
   
    private LocalTime debut;
  
    private LocalTime fin;
    
    private Intervenant intervenant;
    
    public DemandeSoutien(String description, Matiere matiere, Eleve eleve,LocalTime debut) {
        this.description = description;
        this.etat = 0;
        this.date_soutien = new Date();
        this.matiere = matiere;
        this.eleve = eleve;
        this.debut=debut;
        this.fin=null;
        this.intervenant=null;
             
    }

    public DemandeSoutien() {
    }

    public String getLien_visio() {
        return lien_visio;
    }

    public void setLien_visio(String lien_visio) {
        this.lien_visio = lien_visio;
    }

    
    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
    



    public Date getDate_soutien() {
        return date_soutien;
    }

    public void setDate_soutien(Date date_soutien) {
        this.date_soutien = date_soutien;
    }
   
    
    

    public String getDescription() {
        return description;
    }

    public Integer getEtat() {
        return etat;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getDebut() {
        return debut;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setDebut(LocalTime debut) {
        this.debut = debut;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }
    
    
    
}
