package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-04T15:36:02")
@StaticMetamodel(Beacon.class)
public class Beacon_ { 

    public static volatile SingularAttribute<Beacon, Long> dateTime;
    public static volatile SingularAttribute<Beacon, String> signature;
    public static volatile SingularAttribute<Beacon, String> iCan;
    public static volatile SingularAttribute<Beacon, Double> latitude;
    public static volatile SingularAttribute<Beacon, Integer> id;
    public static volatile SingularAttribute<Beacon, Double> longitude;

}