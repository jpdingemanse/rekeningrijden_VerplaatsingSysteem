/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.bean;

//import javax.jms.*;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

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
    
    public void jmsListener(){
        
    }

    @Override
    public void onMessage(Message msg) {
        System.out.println(msg);
    }
}
