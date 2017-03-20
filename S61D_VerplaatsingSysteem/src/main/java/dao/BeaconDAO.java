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
    
    public boolean createNewBeacon(Beacon beacon){
        try{
            em.persist(beacon);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
    
    public List<Beacon> getBeaconWithIcanIdAndTime(int ican, DateTime date){
        List<Beacon> result = em.createQuery("Select b From Beacon b where b.iCan = :ican").setParameter("ican", ican).getResultList();
        return result;
    }

}
