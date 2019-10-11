/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.report;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Sensor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author admin
 */
public class EventReport {
    
    List<Sensor> observables;
    
    public EventReport() {
        
        this.observables = new LinkedList<>();
    }
    
    public void addDevice(Sensor sensor) {
        
        observables.add(sensor);
        
    }
    
    public void printConsumption(){
        
        Iterator<Sensor> it = observables.iterator();
        
        while(it.hasNext()){
            
            try {
                
               it.next().informObserver();
               
                System.out.println(" ");
                
            } catch (NoSuchElementException e){
                
                System.out.println("  !!!!!!!!!  ");
                
            }
        }
    }
    
    
    public void docGenerator() {
        
        PrintStream console = System.out;
        
        File fl = new File("src/reports/EventReport.txt"); 
        
        FileOutputStream flOutStr = null;
        
        try {
            flOutStr = new FileOutputStream(fl);
            
        } catch (FileNotFoundException e) {
            
        }
        
        PrintStream printStream = new PrintStream(flOutStr);
        
        System.setOut(printStream);
        this.printConsumption();
        
        System.setOut(console);
    }
    
    
}
