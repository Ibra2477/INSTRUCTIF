package metier.modele;

import java.time.LocalTime;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Eleve;
import metier.modele.Intervenant;
import metier.modele.Matiere;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-15T18:59:21")
@StaticMetamodel(DemandeSoutien.class)
public class DemandeSoutien_ { 

    public static volatile SingularAttribute<DemandeSoutien, LocalTime> debut;
    public static volatile SingularAttribute<DemandeSoutien, String> lien_visio;
    public static volatile SingularAttribute<DemandeSoutien, Date> date_soutien;
    public static volatile SingularAttribute<DemandeSoutien, String> description;
    public static volatile SingularAttribute<DemandeSoutien, LocalTime> fin;
    public static volatile SingularAttribute<DemandeSoutien, Long> id;
    public static volatile SingularAttribute<DemandeSoutien, Eleve> eleve;
    public static volatile SingularAttribute<DemandeSoutien, Integer> etat;
    public static volatile SingularAttribute<DemandeSoutien, Intervenant> intervenant;
    public static volatile SingularAttribute<DemandeSoutien, Matiere> matiere;

}