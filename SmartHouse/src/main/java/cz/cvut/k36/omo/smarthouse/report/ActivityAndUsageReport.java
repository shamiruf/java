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
public class ActivityAndUsageReport {
    
    List<DeviceAbstract> devices;
    
    public ActivityAndUsageReport() {
        
        this.devices = new LinkedList<>();
        
    }
    
    public void addDevice(DeviceAbstract device) {
        
        devices.add(device);
        
    }
    
    public void printActivityAndUsageReport(){
        
        Iterator<DeviceAbstract> it = devices.iterator();
        
        while(it.hasNext()){
            
            try {
                
                DeviceAbstract actual = it.next();
                
                System.out.println("The " + actual.getClass().getSimpleName() 
                        + " was  used " + actual.getActivity() + " times");
                
                System.out.println();
                
            } catch (NoSuchElementException e){
                
                System.out.println(" !!!No devices!!! ");
                
            }
        }
    }
    
    public void docGenerator() {
        
        PrintStream console = System.out;
        
        File fl = new File("src/reports/ActivityAndUsageReport.txt"); 
        
        FileOutputStream flOutStr = null;
        
        try {
            
            flOutStr = new FileOutputStream(fl);
            
        } catch (FileNotFoundException e) {
            
        }
        
        PrintStream printStream = new PrintStream(flOutStr);
        
        System.setOut(printStream);
        this.printActivityAndUsageReport();
        
        System.setOut(console);
    }
    
}
