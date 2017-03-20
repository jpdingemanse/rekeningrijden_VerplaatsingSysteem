package domain;

import domain.Movement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-20T17:48:16")
@StaticMetamodel(Beacon.class)
public class Beacon_ { 

    public static volatile SingularAttribute<Beacon, Date> dateTime;
    public static volatile SingularAttribute<Beacon, String> signature;
    public static volatile SingularAttribute<Beacon, String> iCan;
    public static volatile SingularAttribute<Beacon, Double> latitude;
    public static volatile SingularAttribute<Beacon, Integer> id;
    public static volatile SingularAttribute<Beacon, Movement> movement;
    public static volatile SingularAttribute<Beacon, Double> longitude;

}