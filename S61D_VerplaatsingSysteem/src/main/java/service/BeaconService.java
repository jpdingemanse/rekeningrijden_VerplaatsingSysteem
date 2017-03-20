/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BeaconDAO;
import domain.Beacon;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author lino_
 */
@Stateless
public class BeaconService {
    @Inject
    BeaconDAO beaconDAO;
    
    public boolean createNewBeacon(Beacon beacon){
        return beaconDAO.createNewBeacon(beacon);
    }
    
    public List<Beacon> getBeaconWithIcanIdAndTime(int ican, DateTime dateTime){
        return beaconDAO.getBeaconWithIcanIdAndTime(ican, dateTime);
    }
}
