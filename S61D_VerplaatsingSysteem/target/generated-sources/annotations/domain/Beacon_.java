package domain;

import domain.Movement;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T15:58:26")
@StaticMetamodel(Beacon.class)
public class Beacon_ { 

    public static volatile SingularAttribute<Beacon, DateTime> timeStamp;
    public static volatile SingularAttribute<Beacon, Movement> startMovement;
    public static volatile SingularAttribute<Beacon, String> signature;
    public static volatile SingularAttribute<Beacon, String> iCan;
    public static volatile SingularAttribute<Beacon, Double> latitude;
    public static volatile SingularAttribute<Beacon, Movement> endMovement;
    public static volatile SingularAttribute<Beacon, Integer> id;
    public static volatile SingularAttribute<Beacon, Double> longitude;

}