/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BeaconDAO;
import domain.Beacon;
import factory.BeaconTransmitter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
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
    @Inject
    BeaconTransmitter beaconTransmitter;

    
    public boolean createNewBeacon(List<Beacon> beacon){
        try{
            for(Beacon b : beacon){
                beaconDAO.createNewBeacon(b);
            }
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    public Map<String, List<Beacon>> getAllRideByIcan(String iCan) {
        Map<String, List<Beacon>> result = new HashMap<>();
        List<Beacon> tempResult = beaconDAO.getAllBeaconByIcan(iCan);
        Long timeStamp = 0L;
        List<Beacon> resultList = new ArrayList<>();
        int counter = 1;
        String counterText = "";
        for (Beacon b : tempResult) {
            if (timeStamp == 0) {
                timeStamp = b.getDateTime();
                resultList.add(b);
            } else {
                if ((b.getDateTime() - timeStamp.longValue()) <= 900) {
                    timeStamp = b.getDateTime();
                    resultList.add(b);
                } else {
                    counterText = counter + "";
                    result.put(counterText, resultList);
                    counter++;
                    timeStamp = b.getDateTime();
                    Beacon lastBeacon = resultList.get(resultList.size() - 1);
                    resultList = new ArrayList<>();
                    resultList.add(lastBeacon);
                    resultList.add(b);
                }
            }
        }
        counterText = counter + "";
        result.put(counterText, resultList);
//        List<Map<String, List<Beacon>>> output = new ArrayList<Map<String, List<Beacon>>>();
//        output.add(result);
        return result;
    }

    public List<Beacon> getBeaconsById(int id) {
        return beaconDAO.getBeaconsById(id);
    }

    public List<Beacon> getBeaconsByDate(String Ican) {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);
        Timestamp beginDay = Timestamp.valueOf(todayMidnight);
        Timestamp endDay = Timestamp.valueOf(tomorrowMidnight);
        List<Beacon> beacons = beaconDAO.getBeaconsByDay(beginDay, endDay, Ican);
        beaconTransmitter.SendBeaconsToAdministratie(beacons);
        return beacons;
    }

    public Map<String, List<Beacon>> getBeaconsByiCanAndDate(String iCan, String date) {
        Map<String, List<Beacon>> result = new HashMap<>();
        List<Beacon> tempResult = beaconDAO.getBeaconsByIcanAndDate(iCan, date);
        Long timeStamp = 0L;
        List<Beacon> resultList = new ArrayList<>();
        int counter = 1;
        String counterText = "";
        for (Beacon b : tempResult) {
            if (timeStamp == 0) {
                timeStamp = b.getDateTime();
                resultList.add(b);
            } else {
                if ((b.getDateTime() - timeStamp.longValue()) <= 900) {
                    timeStamp = b.getDateTime();
                    resultList.add(b);
                } else {
                    counterText = counter + "";
                    result.put(counterText, resultList);
                    counter++;
                    timeStamp = b.getDateTime();
                    Beacon lastBeacon = resultList.get(resultList.size() - 1);
                    resultList = new ArrayList<>();
                    resultList.add(lastBeacon);
                    resultList.add(b);
                }
            }
        }
        counterText = counter + "";
        result.put(counterText, resultList);
//        List<Map<String, List<Beacon>>> output = new ArrayList<Map<String, List<Beacon>>>();
//        output.add(result);
        return result;
    }
    
    public Map<String, List<Beacon>> getBeaconsByPeriod(String iCan, String dateFrom, String dateTo) {
        Map<String, List<Beacon>> result = new HashMap<>();
        List<Beacon> tempResult = beaconDAO.getAllBeaconByPeriod(iCan, dateFrom, dateTo);
        Long timeStamp = 0L;
        List<Beacon> resultList = new ArrayList<>();
        int counter = 1;
        String counterText = "";
        for (Beacon b : tempResult) {
            if (timeStamp == 0) {
                timeStamp = b.getDateTime();
                resultList.add(b);
            } else {
                if ((b.getDateTime() - timeStamp.longValue()) <= 900) {
                    timeStamp = b.getDateTime();
                    resultList.add(b);
                } else {
                    counterText = counter + "";
                    result.put(counterText, resultList);
                    counter++;
                    timeStamp = b.getDateTime();
                    Beacon lastBeacon = resultList.get(resultList.size() - 1);
                    resultList = new ArrayList<>();
                    resultList.add(lastBeacon);
                    resultList.add(b);
                }
            }
        }
        counterText = counter + "";
        result.put(counterText, resultList);
//        List<Map<String, List<Beacon>>> output = new ArrayList<Map<String, List<Beacon>>>();
//        output.add(result);
        return result;
    }
}
