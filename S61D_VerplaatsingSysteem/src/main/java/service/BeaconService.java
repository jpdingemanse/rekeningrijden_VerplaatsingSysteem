/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BeaconDAO;
import domain.Beacon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

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
    
    public List<List<Beacon>> getAllRideByIcan(String iCan){
        List<List<Beacon>> result = new ArrayList<>();
        List<Beacon> tempResult = beaconDAO.getAllBeaconByIcan(iCan);
        Long timeStamp = 0L;
        List<Beacon> resultList = new ArrayList<>();
        for(Beacon b : tempResult){
            if(timeStamp == 0){
                timeStamp = b.getDateTime();
                resultList.add(b);
            }else{
                if((b.getDateTime() - timeStamp.longValue()) <= 900){
                    timeStamp = b.getDateTime();
                    resultList.add(b);
                }else{
                    result.add(resultList);
                    timeStamp = b.getDateTime();
                    Beacon lastBeacon = resultList.get(resultList.size() - 1);
                    resultList = new ArrayList<>();
                    resultList.add(lastBeacon);
                    resultList.add(b);
                }
            }
        }
        result.add(resultList);
//        List<Map<String, List<Beacon>>> output = new ArrayList<Map<String, List<Beacon>>>();
//        output.add(result);
        return result;
    }
        
    public List<Beacon> getBeaconsById(int id){
        return beaconDAO.getBeaconsById(id);
    }
}
