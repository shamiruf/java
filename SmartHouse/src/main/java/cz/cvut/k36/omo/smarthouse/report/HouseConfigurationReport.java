/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.report;

import cz.cvut.k36.omo.smarthouse.model.HouseConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author admin
 */
public class HouseConfigurationReport {
    
    public void DocGenerator() {
        
        PrintStream console = System.out;
        
        File fl = new File("src/reports/HouseConfigurationReport.txt"); 
        
        FileOutputStream flOutStr = null;
        
        try {
            flOutStr = new FileOutputStream(fl);
            
        } catch (FileNotFoundException e) {
            
        }
        
        PrintStream printStream = new PrintStream(flOutStr);
        
        System.setOut(printStream);
        
        HouseConfiguration home = new HouseConfiguration();
        home.printHouseConfiguration();
        
        System.setOut(console);
    }
    
}
