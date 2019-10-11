/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.visitor;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.CDplayer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Computer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Lights;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.TV;

/**
 *
 * @author admin
 */
public class API {
    
    TurnOnDevices on;
    
    TurnOffDevices off;
    
    public API() {
        
        this.on = new TurnOnDevices();
        
        this.off = new TurnOffDevices();
    }
    
    public void on(Lights lights) {
        
        lights.accept(on);
        
    }
    
    public void off(Lights lights) {
        
        lights.accept(off);
        
    }
    
    public void on(CDplayer cdplayer) {
        
        cdplayer.accept(on);
        
    }
    
    public void off(CDplayer cdplayer) {
        
        cdplayer.accept(off);
        
    }
    
    public void on(TV tv) {
        
        tv.accept(on);
    }
    
    public void off(TV tv) {
        
        tv.accept(off);
    }
    
    public void on(Computer computer) {
        
        computer.accept(on);
        
    }

    public void off(Computer computer) {
        
        computer.accept(off);
        
    }
    
    public void insertCD(CDplayer cd) {
        
        cd.insertCD();
    }
}
