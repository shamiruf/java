/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.statemachine;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;

/**
 *
 * @author admin
 */
public class DeviceOff implements DeviceState {
    
    private final DeviceAbstract deviceAbstract;
    
    public DeviceOff(DeviceAbstract deviceAbstract) {
        
        this.deviceAbstract = deviceAbstract;
        
    }

    @Override
    public void off() {
        
        System.out.println(" State off is active ");
        
    }

    @Override
    public void on() {
        
        System.out.println("State on");
        
    }

    @Override
    public void sleep() {
        
        System.out.println(" State off ");
    }
    
}
