/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Beacon;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import service.BeaconService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Beacon")
public class BeaconResource {
    @Inject
    BeaconService beaconService;
    
    @POST
    @Path("CreateBeacon")
    @Consumes("application/json")
    public boolean createBeacon(Beacon beacon){
        return beaconService.createNewBeacon(beacon);
    }
}
