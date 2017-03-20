/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author lino_
 */
@Entity
public class Beacon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String iCan;
    private double latitude;
    private double longitude;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateTime;
    private String  signature; 
    @ManyToOne
    private Movement movement;

    public Beacon() {
    }
   

    public Beacon(String iCan, double latitude, double longitude, Date dateTime) {
        this.iCan = iCan;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateTime = dateTime;
        
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    public String getiCan() {
        return iCan;
    }

    public void setiCan(String iCan) {
        this.iCan = iCan;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    
    
}
