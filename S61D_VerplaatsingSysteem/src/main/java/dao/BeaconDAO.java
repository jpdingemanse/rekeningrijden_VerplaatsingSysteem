/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Beacon;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author lino_
 */
@Stateless
public class BeaconDAO {
    @PersistenceContext
    EntityManager em;

    public BeaconDAO() {
    }
    public Beacon findBeacon(Beacon beacon){
        List<Beacon> result = em.createQuery("Select b from Beacon b where b.iCan = :ican").setParameter("ican", beacon.getiCan()).getResultList();
        Beacon beaconResult = result.get(result.size() - 1);
        if(beaconResult.getLatitude() == beacon.getLatitude() && beaconResult.getLongitude() == beacon.getLongitude()){
            return beaconResult;
        }
        return null;
    }
    public boolean createNewBeacon(Beacon beacon){
        try{
            if(findBeacon(beacon) != null){
                return false;
            }else{
                em.persist(beacon);
                return true;
            }
            
        }catch (Exception ex){
            return false;
        }
    }
    
    public List<Beacon> getBeaconWithIcanIdAndTime(int ican, DateTime date){
        List<Beacon> result = em.createQuery("Select b From Beacon b where b.iCan = :ican").setParameter("ican", ican).getResultList();
        return result;
    }

}
