/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory;

import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.MotionSensor;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Observer;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Sensor;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceOff;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceOn;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceState;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Lights extends DeviceAbstract implements Observer {
    
    MotionSensor motionSensor;
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    Date date = new Date();
    
    public Lights() {
        
        super();
    }
    

    @Override
    public void setSensor(Sensor sensor) {
        
        this.motionSensor = (MotionSensor) sensor;
        
        this.motionSensor.addObserver(this);
        
    }

    @Override
    public void getUpdate() {
        
        if (this.deviceState.getClass() != DeviceOff.class) {
            
            System.out.println("Lights are On");
            
        } else {
            
            System.out.println("Change state of device to on");
            
            this.deviceState = new DeviceOn(this);
        }
        
        if (this.deviceState.getClass() == DeviceOff.class) {
            
            this.eventListener.update("Changed state of lights to off at "
                    + dateFormat.format(date), 163);
            
        } else if (this.deviceState.getClass() == DeviceOn.class) {
            
            this.eventListener.update("Changed state of lights to on at "
                    + dateFormat.format(date), 0);
        }
        
    }
    
    @Override
    public void setDeviceState(DeviceState deviceState) {
        
        this.deviceState = deviceState;
        
        if (this.deviceState.getClass() == DeviceOn.class) {
            System.out.println(" Device on class ");
            this.eventListener.update("Changed state of lights to on at "
                    + dateFormat.format(date), 0);
            
        } else if (this.deviceState.getClass() == DeviceOff.class) {
            
            this.eventListener.update("Changed state of lights to off at " 
                    + dateFormat.format(date), 164);
            
            
        }
    }
    
    public void setEventListener(EventListener eventListener) {
        
        this.eventListener = eventListener;
    }

    
}
