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
public class WindSensor implements Sensor{
    
    private boolean changed;
    
    private String message;
    
    private List<Observer> observers;
    
    public WindSensor() {
        
        this.observers = Collections.synchronizedList(new ArrayList<Observer>());
        
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

    @Override
    public void informObserver() {
        
        System.out.println("Wind sensor has been detected wind, get the blinds down");
        
        observers.stream().forEach((o) -> {
            o.getUpdate();
            
        });
    }
    
    public void inform(String message) {
        
        this.message = message;
        
        this.changed = true;
        
        informObserver();
    }
    
}
