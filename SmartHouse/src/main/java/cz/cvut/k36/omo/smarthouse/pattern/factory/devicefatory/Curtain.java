/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory;

import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Observer;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Sensor;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.WindSensor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Curtain extends DeviceAbstract implements Observer{
    
    EventListener eventListener;
    
    Sensor windSensor;
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    
    public Curtain(){}
    
    public Curtain(WindSensor windSensor, EventListener eventListener) {
        
        super();
        
        this.windSensor = windSensor;
        
        this.windSensor.addObserver(this);
        
        this.eventListener = eventListener;
    }
    

    @Override
    public void setSensor(Sensor sensor) {
        
        this.windSensor = sensor;
        
        this.windSensor.addObserver(this);
        
    }

    @Override
    public void getUpdate() {
        
        this.eventListener.update("Curtain go DOWN at " + dateFormat.format(date), 10);
    }
    
    public void setEventListener(EventListener eventListener) {
        
        this.eventListener = eventListener;
    }
}
