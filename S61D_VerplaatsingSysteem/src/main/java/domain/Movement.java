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

/**
 *
 * @author lino_
 */
@Entity
public class Movement implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Beacon startPoint;
    @OneToOne
    private Beacon endPoint;
    private String licensePlate;

    public Movement() {
    }

    public Movement(Beacon startPoint, Beacon endPoint, String licensePlate) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Beacon getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Beacon startPoint) {
        this.startPoint = startPoint;
    }

    public Beacon getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Beacon endPoint) {
        this.endPoint = endPoint;
    }
    
    
}
