/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory;

import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;

/**
 *
 * @author admin
 */
public class CDplayer extends DeviceAbstract {
    
    EventListener eventListener;
    boolean hasCD = false;
    
    public CDplayer(){
        super();
    }
    
    public void insertCD() {
        
        if (hasCD == true) {
            
            System.out.println("CD is already inserted in CDplayer ");
        
        } else {
            
            hasCD = true;
            
            System.out.println("CD has been inserted in CDplayer ");
        
        }
    }
    
    public void setEventListener(EventListener eventListener) {
        
        this.eventListener = eventListener;
        
    }
   
}
