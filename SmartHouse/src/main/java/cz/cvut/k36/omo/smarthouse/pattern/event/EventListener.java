/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.event;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class EventListener {
    
    public List<String> action;
    
    private int consump = 0;
    
    public EventListener() {
        
        this.action = new ArrayList();
    }
    
    public int getAction() {
        
        int i = 0;
        
        for (String action : this.action) {
            
            i++;
        }
        
        return i;
    }
    
    public void printAction() {
        
        for (String action : this.action) {
            
            System.out.println(action);
        }
    }
    
    public void update(String message, int cons) {
        System.out.println(" Device on class ");
        action.add(message);
        consump = consump + cons;
    }
    
    public int getConsumption() {
        
        return consump;
    }
    
    public void DocGenerator() {
        
        PrintStream console = System.out;
        
        File fl = new File("src/reports/EventReport.txt"); 
        
        FileOutputStream flOutStr = null;
        
        try {
            
            flOutStr = new FileOutputStream(fl);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        PrintStream printStream = new PrintStream(flOutStr);
        
        System.setOut(printStream);
        this.printAction();
        
        System.out.println(this.getConsumption() + " - consumption");
        
        System.setOut(console);
    }

}
