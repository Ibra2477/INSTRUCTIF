package metier.modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-15T18:59:21")
@StaticMetamodel(Intervenant.class)
public abstract class Intervenant_ extends Personne_ {

    public static volatile SingularAttribute<Intervenant, Integer> nbSoutien;
    public static volatile SingularAttribute<Intervenant, Long> tel;
    public static volatile SingularAttribute<Intervenant, Integer> niveaumin;
    public static volatile SingularAttribute<Intervenant, Integer> niveaumax;
    public static volatile SingularAttribute<Intervenant, Boolean> disponible;

}