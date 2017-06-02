/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import com.google.gson.Gson;
import domain.Beacon;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author victo
 */
@Stateless
public class BeaconTransmitter {
     public boolean SendBeaconsToAdministratie(List<Beacon> beacons) {
        Gson gson = new Gson();
        String jsonToString = gson.toJson(beacons);
        try {
            String url = "http://192.168.24.43:8080/S61D_RekeneningAdministratie/api/Beacon/CreateBeacon";
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonToString);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            int httpCode = response.getStatusLine().getStatusCode();

            if (httpCode != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            return true;
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MovementTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(MovementTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
}
