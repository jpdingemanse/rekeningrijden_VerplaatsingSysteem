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
    
    
    public void jmsListener(){
        
    }

    @Override
    public void onMessage(Message msg) {
        System.out.println(msg);
        TextMessage message = (TextMessage) msg;
        Type listType = new TypeToken<List<Beacon>>() {}.getType();
        try {  
            List<Beacon> beacons = new Gson().fromJson(message.getText(), listType);
            bs.createNewBeacon(beacons);
        } catch (JMSException ex) {
            Logger.getLogger(JmsConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
