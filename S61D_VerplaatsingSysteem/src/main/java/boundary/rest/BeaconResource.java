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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public List<Beacon> getMovementPerIcan(@PathParam("iCan")String iCan){
        try {
            List<List<Beacon>> result = beaconService.getAllRideByIcan(iCan);
            List<Beacon> output = result.get(result.size() - 1);
            return output;
        }catch (Exception ex){
            return null;
        }
        
    }
    
}
