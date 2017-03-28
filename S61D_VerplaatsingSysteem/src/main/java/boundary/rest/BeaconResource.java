/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Beacon;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    
    @GET
    @Path("GetMovementPerIcan/{iCan}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Beacon> getMovementPerIcan(@PathParam("iCan")String iCan){
        try {
            Map<String, List<Beacon>> result = beaconService.getAllRideByIcan(iCan);
            return result.get("1");
        }catch (Exception ex){
            return null;
        }
        
    }
    
}
