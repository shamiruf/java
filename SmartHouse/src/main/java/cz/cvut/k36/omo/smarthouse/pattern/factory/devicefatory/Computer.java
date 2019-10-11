/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory;

import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceOff;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceOn;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceState;

/**
 *
 * @author admin
 */
public class Computer extends DeviceAbstract{
    
    EventListener eventListener;
    
    public Computer() {
        
        super();
    }
    
    public void setEventListener(EventListener eventListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public DeviceState getDeviceState() {
        
        if (this.deviceState.getClass() == DeviceOff.class) {
            
            System.out.println("Computer is off");
            
        } else {
            System.out.println("Computer on");
        }
        return this.deviceState;
    }

    @Override
    public void setDeviceState(DeviceState deviceState) {
        this.deviceState = deviceState;
        System.out.println(" Я ЗАШУЛ В СЕТДЕВАЙССТЕЙТ");
        if (this.deviceState.getClass() == DeviceOff.class) {
            System.out.println(" DEVICE OFF FFFFF");
            this.eventListener.update("Computer off", 2);
        } else if (this.deviceState.getClass() == DeviceOn.class) {
            this.eventListener.update("Computer is on", 1);
        }
    }
    
    public void update() {
        if (this.deviceState.getClass() == DeviceOff.class) {
            System.out.println("Computer is changeing in off");
            this.deviceState = new DeviceOn(this);
        } else {
            System.out.println("COmputeris already On");
        }
        if (this.deviceState.getClass() == DeviceOff.class) {
            this.eventListener.update("Computer is off ", 98);
        } else if (this.deviceState.getClass() == DeviceOn.class) {
            this.eventListener.update("Device state on", 0);
        }
    }
}
