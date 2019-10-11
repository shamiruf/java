/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.model;

import java.util.List;

/**
 *
 * @author admin
 */
public class Floor implements HomeObject{
    
    List <Room> room;
    
    public int floorNumber;
    
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void setHomeObject(List area) {
        this.room = area;
        
    }

    @Override
    public List <Room> getHomeObject() {
        
        return room;
    }

    @Override
    public void print(String print) { 
        
        System.out.println(print);
        
    }
    
}
