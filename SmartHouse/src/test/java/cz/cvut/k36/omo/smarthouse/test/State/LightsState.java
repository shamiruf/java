/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.test.State;

import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;
import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.FactoryCreator;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Lights;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class LightsState {
    
    public Lights changeLightsState(){
        
        Lights lights = new Lights();
        
        EventListener eventListener = new EventListener();
        
        lights.setEventListener(eventListener);
        
        AbstractFactory homeInhabitant =  FactoryCreator.getFactory("HomeInhabitant");
        HomeInhabitantAbstract man = homeInhabitant.getHomeInhabitant("Man");
        
        man.on(lights);
        lights.getDeviceState();
        return lights;
    }


    @Test
    public void testLightsState() throws Exception {
        
    }
    
}
