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
public class DeviceOn implements DeviceState {
    
    private DeviceAbstract deviceAbstract;
    
    public DeviceOn(DeviceAbstract deviceAbstract) {
        
        this.deviceAbstract = deviceAbstract;
        
    }

    @Override
    public void off() {
        
        System.out.println("State off");
        
        deviceAbstract.setDeviceState(new DeviceOff(deviceAbstract));
    }

    @Override
    public void on() {
        
        System.out.println(" State on is active ");
    }

    @Override
    public void sleep() {
        
        System.out.println(" State on ");
    }
    
}
