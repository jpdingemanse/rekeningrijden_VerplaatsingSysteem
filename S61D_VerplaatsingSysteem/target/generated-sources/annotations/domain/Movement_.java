package domain;

import domain.Beacon;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-20T19:57:24")
@StaticMetamodel(Movement.class)
public class Movement_ { 

    public static volatile SingularAttribute<Movement, String> licensePlate;
    public static volatile SingularAttribute<Movement, Integer> id;
    public static volatile ListAttribute<Movement, Beacon> ride;

}