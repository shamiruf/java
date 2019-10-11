/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.CDplayer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Computer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Lights;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.TV;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Observer;
import cz.cvut.k36.omo.smarthouse.pattern.visitor.API;

/**
 *
 * @author admin
 */
public abstract class HomeInhabitantAbstract implements Observer{
    
    abstract public void getName();
    
    API api = new API();
    
    public void on(Lights light) {
        
        api.on(light);
    }

    public void off(Lights light) {
        
        api.off(light);
    }
    
    public void on(CDplayer cd) {
        
        api.on(cd);
    }

    public void off(CDplayer cd) {
        
        api.off(cd);
    }

    
    public void on(TV tv) {
        
        api.on(tv);
    }

    public void off(TV tv) {
        
        api.off(tv);
    }

    public void on(Computer computer) {
        
        api.on(computer);
    }
    
    public void off(Computer computer) {
        
        api.off(computer);
    }
}
