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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author lino_
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Beacon.getByIcan", query="Select b from Beacon b where b.ICAN = :ican"),
    @NamedQuery(name = "Beacon.getBeaconsPerDay", query="Select b from Beacon b where b.ICAN = :iCan and b.dateTime BETWEEN :start and :end"),
    @NamedQuery(name="Beacon.getByPeriod", query="Select b from Beacon b where b.ICAN = :ican AND b.dateTime > :dateFrom AND b.dateTime < :dateTo"),
    @NamedQuery(name="Beacon.getByICanAndDate", query="Select b from Beacon b where b.ICAN = :ican AND b.dateTime like :date "),
   
})
public class Beacon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ICAN;
    private double latitude;
    private double longitude;
    private Long dateTime;
    private String  signature; 

    public Beacon() {
    }
   

    public Beacon(String iCan, double latitude, double longitude, Long dateTime) {
        this.ICAN = iCan;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateTime = dateTime;
    }

    public String getICAN() {
        return ICAN;
    }

    public void setICAN(String ICAN) {
        this.ICAN = ICAN;
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

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }



  
    
    
}
