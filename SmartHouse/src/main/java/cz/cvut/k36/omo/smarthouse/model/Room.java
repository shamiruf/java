/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Room implements HomeObject{
    
    public String roomName;
    
    List<Window> window;
    
    public Room(String roomName) {
        
        this.roomName = roomName;
        
    }
    
    public String getRoomName() {
        
        return roomName;
    }

    public void setRoomName(String roomName) {
        
        this.roomName = roomName;
    }
    

    @Override
    public void setHomeObject(List area) {
        
        this.window = area;
    }

    @Override
    public List<Window> getHomeObject() {
        
        return window;
    }

    @Override
    public void print(String print) {
        
        System.out.println(print);
        
    }
    
}
