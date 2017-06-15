/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.bean;

//import javax.jms.*;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import domain.Beacon;
import factory.JMSSender;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import service.BeaconService;

//import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author lino_
 */
@MessageDriven(name = "testmdb", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/beaconqueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "beaconqueue"),
    @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-5.12.0")
   
})
public class JmsConnector implements MessageListener {
    @Inject
    BeaconService bs;
    
    private static final String deUrl = "tcp://192.168.24.38:61616";
    private static final String bgUrl = "tcp://192.168.25.69:61616";
    private static final String chUrl = "tcp://192.168.24.27:61616";
    
    List<Beacon> deBeacon = new ArrayList<>();
    List<Beacon> bgBeacon = new ArrayList<>();
    List<Beacon> chBeacon = new ArrayList<>();
    public void jmsListener(){
        
    }

    @Override
    public void onMessage(Message msg) {
        deBeacon.clear();
        bgBeacon.clear();
        chBeacon.clear();
        Gson gson = new Gson();
        System.out.println(msg);
        TextMessage message = (TextMessage) msg;
        Type listType = new TypeToken<List<Beacon>>() {}.getType();
        try {  
            List<Beacon> beacons = new Gson().fromJson(message.getText(), listType);
            for(Beacon b : beacons){
                if(b.getICAN().contains("NL")){
                     bs.createNewBeacon(beacons);
                }
                if(b.getICAN().contains("DE")){
                    deBeacon.add(b);
                }
                if(b.getICAN().contains("CH")){
                    chBeacon.add(b);
                }
                if(b.getICAN().contains("BG")){
                    bgBeacon.add(b);
                }
            }
            if(!deBeacon.isEmpty()){
                String beaconString = gson.toJson(deBeacon);
                JMSSender.sendInvoiceInternal(beaconString, deUrl);
            }
            if(!chBeacon.isEmpty()){
                String beaconString = gson.toJson(chBeacon);
                JMSSender.sendInvoiceInternal(beaconString,chUrl);
            }
            if(!bgBeacon.isEmpty()){
                String beaconString = gson.toJson(bgBeacon);
                JMSSender.sendInvoiceInternal(beaconString, bgUrl);
            }
        } catch (JMSException ex) {
            Logger.getLogger(JmsConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
