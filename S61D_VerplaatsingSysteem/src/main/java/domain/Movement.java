/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "movement")
    private List<Beacon> ride;
    private String licensePlate;

    public Movement() {
    }

    public Movement(String licensePlate) {
        this.licensePlate = licensePlate;
        this.ride = new ArrayList<>();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public List<Beacon> getRide() {
        return ride;
    }

    public void setRide(List<Beacon> ride) {
        this.ride = ride;
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
    
    public void addBeacon(Beacon beacon){
        this.ride.add(beacon);
    }

   
    
    
}
