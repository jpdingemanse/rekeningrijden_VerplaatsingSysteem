/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MovementDAO;
import domain.Beacon;
import domain.Movement;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Stateless
public class MovementService {
    @Inject
    MovementDAO movementDAO;
    
    public Movement creanteMovement(Movement movement){
        return movementDAO.createNewMovement(movement);
    }
    
    public boolean addMovement(Movement movement, Beacon beacon){
        return movementDAO.addMovementToList(movement, beacon);
    }
}
