/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Beacon;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    public Beacon findBeacon(Beacon beacon) {
        List<Beacon> result = em.createNamedQuery("Beacon.getByIcan").setParameter("ican", beacon.getICAN()).getResultList();
        if (result.isEmpty()) {
            return null;
        }
        Beacon beaconResult = result.get(result.size() - 1);
        if (beaconResult.getLatitude() == beacon.getLatitude() && beaconResult.getLongitude() == beacon.getLongitude()) {
            return beaconResult;
        }
        return null;
    }

    public boolean createNewBeacon(Beacon beacon) {
        try {
            if (findBeacon(beacon) != null) {
                return false;
            } else {
                em.persist(beacon);
                return true;
            }

        } catch (Exception ex) {
            return false;
        }
    }

    public List<Beacon> getBeaconsById(int id) {
        List<Beacon> result = em.createQuery("Select b From Beacon b where b.movement.id = :id").setParameter("id", id).getResultList();
        return result;
    }

    public List<Beacon> getAllBeaconByIcan(String iCan) {
        try {
            List<Beacon> result = em.createNamedQuery("Beacon.getByIcan").setParameter("ican", iCan).getResultList();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Beacon> getBeaconsByDay(Timestamp begin, Timestamp end, String iCan) {
        try {
            List<Beacon> result = em.createNamedQuery("Beacon.getBeaconsPerDay").setParameter("begin", begin).setParameter("end", end).setParameter("iCan", iCan).getResultList();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Beacon> getAllBeaconByPeriod(String iCan, String dateFrom, String dateTo) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date datumVan = dateFormat.parse(dateFrom);
            Date datumTot = dateFormat.parse(dateTo);
            long timeFrom = datumVan.getTime();
            long timeTo = datumTot.getTime();
            
//            System.out.println(timeFrom);
//            System.out.println(timeTo);
            
            List<Beacon> result = em.createNamedQuery("Beacon.getByPeriod").setParameter("ican", iCan).setParameter("dateFrom", timeFrom).setParameter("dateTo", timeTo).getResultList();
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Beacon> getBeaconsByIcanAndDate(String iCan, String date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date datumVan = dateFormat.parse(date);
           
            long timeFrom = datumVan.getTime();
            Calendar cal = Calendar.getInstance();    
            cal.setTime( dateFormat.parse(date));    
            cal.add( Calendar.DATE, 1 );  
            long timeTo = cal.getTimeInMillis();
            
            
            //System.out.println(iCan + " " +timeFrom + " " +timeTo);
            List<Beacon> result = em.createNamedQuery("Beacon.getByPeriod").setParameter("ican", iCan).setParameter("dateFrom", timeFrom).setParameter("dateTo", timeTo).getResultList();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
}
