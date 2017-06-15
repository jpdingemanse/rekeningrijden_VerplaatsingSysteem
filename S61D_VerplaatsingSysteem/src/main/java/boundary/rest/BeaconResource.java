/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Beacon;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    public boolean createBeacon(List<Beacon> beacon){
        if(beacon.size() != 0){
            return beaconService.createNewBeacon(beacon);
        }
        return false;
    }

    @GET
    @Path("GetMovementPerIcan/{iCan}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Beacon> getMovementPerIcan(@PathParam("iCan") String iCan) {
        try {
            List<Beacon> result = beaconService.getAllRideByIcan(iCan);
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @GET
    @Path("getMovementPerMonth/{iCan}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Beacon> getMovementPerMonth(@PathParam("iCan") String iCan) {
        try {
            List<Beacon> result = beaconService.getBeaconsPerMonth(iCan);
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @GET
    @Path("GetMovementPerIcanAndDate/{iCan}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Beacon> getMovementPerIcanAndDate(@PathParam("iCan") String iCan, @PathParam("date") String date) {
        try {
            List<Beacon> result = beaconService.getBeaconsByiCanAndDate(iCan, date);
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
    
//    @GET
//    @Path("GetMovementPerIcanPeriod/{iCan}/{dateFrom}/{dateTo}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Beacon> getMovementPerIcanPeriod(@PathParam("iCan") String iCan, @PathParam("dateFrom") String dateFrom, @PathParam("dateTo")String dateTo) {
//        try {
//            Map<String, List<Beacon>> result = beaconService.getBeaconsByPeriod(iCan, dateFrom, dateTo);
//            
//            return result.get("1");
//        } catch (Exception ex) {
//            return null;
//        }
//    }

//    @GET
//    @Path("GetCarMovementsADay/{iCan}")
//    public List<Beacon> getCarMovementsADay(@PathParam("iCan") String iCan) {
//        return beaconService.getBeaconsByDate(iCan);
//    }
    
    @GET
    @Path("GetAllBeaconPerPeriod")
    public List<Beacon> getAllBeaconPerPeriod(){
        return beaconService.getAllBeaconPerPeriod();
    }

}
