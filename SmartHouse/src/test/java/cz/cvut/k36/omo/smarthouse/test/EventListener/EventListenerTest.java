/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.test.EventListener;

import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;
import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.FactoryCreator;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Computer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class EventListenerTest {
    
    EventListener eventListener;
    
    Computer computer;
    
    @Before
    public void stateChange(){
        
        eventListener = new EventListener();
        
        computer = new Computer();
        
        computer.setEventListener(eventListener);
        
        AbstractFactory homeInhabitant = FactoryCreator.getFactory("HomeInhabitant");
        HomeInhabitantAbstract man = homeInhabitant.getHomeInhabitant("Man");
        
        System.out.println(man);
        System.out.println(computer);
        man.on(computer);
        man.off(computer);
        man.off(computer);
    }
    
    @Test
    public void eventListenerTest1(){
        
        assertEquals(eventListener.action.size(), 4);

    }
    
    @Test
    public void eventListenerTest2(){
        
        assertNotEquals(eventListener.getConsumption(), 1);

    }
    
}
