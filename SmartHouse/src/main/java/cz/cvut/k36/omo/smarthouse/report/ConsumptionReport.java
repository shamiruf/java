/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.report;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
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
public class ConsumptionReport {
    
    List<DeviceAbstract> devices;
    
    public ConsumptionReport() {
        
        this.devices = new LinkedList<>();
        
    }
    
    public void addDevice(DeviceAbstract device) {
        
        devices.add(device);
        
    }
    
    public void printConsumption(){
        
        Iterator<DeviceAbstract> it = devices.iterator();
        
        while(it.hasNext()){
            
            try {
                
                DeviceAbstract actual = it.next();
                
                String consumpCost = String.format("%.6f", actual.calcTotalConsumpCost());
                
                String consump = String.format("%.6f", actual.calcTotalConsump());
                
                System.out.println("The consumption of " + actual.getClass().getSimpleName() 
                        + " is " + consumpCost + " CZK ");
                
                System.out.println("The consumption of " + actual.getClass().getSimpleName() 
                        + " is " + consump + " w/hour.");
                
                System.out.println();
                
            } catch (NoSuchElementException e){
                
                System.out.println(" !!!No devices!!! ");
                
            }
        }
    }
    
    public void generateDoc() {
        
        PrintStream console = System.out;
        
        File fl = new File("src/reports/ConsumptionReport.txt"); 
        
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
