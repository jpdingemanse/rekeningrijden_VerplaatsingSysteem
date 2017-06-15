/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import boundary.bean.JmsConnector;
import dao.BeaconDAO;
import domain.Beacon;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Singleton
@Startup
public class Init {
    @Inject
    BeaconDAO beaconDAO;
    
    @PostConstruct
    public void Init(){
//        beaconDAO.createNewBeacon(new Beacon("NL12345", 2.1, 1.1, new Long(100)));
//        beaconDAO.createNewBeacon(new Beacon("NL12345", 2.2, 1.1, new Long(101)));
//        beaconDAO.createNewBeacon(new Beacon("NL12345", 2.3, 1.1, new Long(102)));
//        beaconDAO.createNewBeacon(new Beacon("NL12345", 2.4, 1.1, new Long(103)));
//        
//        beaconDAO.createNewBeacon(new Beacon("NL12345", 2.5, 1.1, new Long(1004)));
//        beaconDAO.createNewBeacon(new Beacon("NL12345", 2.6, 1.1, new Long(1005)));
//        beaconDAO.createNewBeacon(new Beacon("NL12345", 2.7, 1.1, new Long(1006)));
        
//        JmsConnector jms = new JmsConnector();
//        jms.jmsListener();
    }
}
