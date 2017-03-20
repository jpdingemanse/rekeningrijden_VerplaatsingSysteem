/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Beacon;
import domain.Movement;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lino_
 */
@Stateless
public class MovementDAO implements Serializable {
    @PersistenceContext
    EntityManager em;

    public MovementDAO() {
    }
    
    public Movement createNewMovement(Movement movement){
        em.persist(movement);
        Movement result = em.find(Movement.class, movement.getId());
        return result;
    }
    
    public boolean addMovementToList(Movement movement, Beacon beacon){
        try{
            Movement result = em.find(Movement.class, movement.getId());
            result.addBeacon(beacon);
            em.merge(result);
            return true;
        }catch (Exception ex){
            return false;
        }
    }   
}
