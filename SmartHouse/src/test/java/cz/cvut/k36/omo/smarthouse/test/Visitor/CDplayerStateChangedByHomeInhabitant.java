/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.test.Visitor;

import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;
import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.FactoryCreator;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.CDplayer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceOn;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class CDplayerStateChangedByHomeInhabitant {
    
    CDplayer cdplayer;
    
    @Before
    public void changeCDplayerState(){
        
        cdplayer = new CDplayer();
        
        EventListener eventListener = new EventListener();
        
        cdplayer.setEventListener(eventListener);
        
        AbstractFactory homeInhabitant =  FactoryCreator.getFactory("HomeInhabitant");
        HomeInhabitantAbstract man = homeInhabitant.getHomeInhabitant("Man");
        man.on(cdplayer);
    }
    
    @Test
    public void testStateChangebyHuman(){
        
        assertEquals(cdplayer.deviceState.getClass(), DeviceOn.class);

    }
    
}
