/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.observer.sensor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class MotionSensor implements Sensor{
    
    private List<Observer> observers;
    
    public MotionSensor() {
        
        this.observers = Collections.synchronizedList(new ArrayList<Observer>());
        
    }

    @Override
    public void informObserver() {
        
        System.out.println("Motion sensor has been detected motion, turn on lights");
        
        observers.stream().forEach((o) -> {
            o.getUpdate();
            
        });
        
    }

    @Override
    public void addObserver(Observer o) {
        
        if (!this.observers.contains(o))
            
            this.observers.add(o);
        
        if (o == null)
            
            throw new NullPointerException(" !!!No observer!!! ");
        
    }

    @Override
    public void deleteObserver(Observer o) {
        
        observers.remove(o);
        
    }
    
}
