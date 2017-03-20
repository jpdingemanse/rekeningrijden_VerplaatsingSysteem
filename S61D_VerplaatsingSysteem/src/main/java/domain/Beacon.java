/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
    private DateTime timeStamp;
    private String  signature; 
    @OneToOne(mappedBy = "startPoint")
    private Movement startMovement;
    @OneToOne(mappedBy = "endPoint")
    private Movement endMovement;

    public Beacon() {
    }
   

    public Beacon(String iCan, double latitude, double longitude, DateTime timeStamp) {
        this.iCan = iCan;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeStamp = timeStamp;
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

    public DateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(DateTime timeStamp) {
        this.timeStamp = timeStamp;
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

    public Movement getStartMovement() {
        return startMovement;
    }

    public void setStartMovement(Movement startMovement) {
        this.startMovement = startMovement;
    }

    public Movement getEndMovement() {
        return endMovement;
    }

    public void setEndMovement(Movement endMovement) {
        this.endMovement = endMovement;
    }
    
    
}
