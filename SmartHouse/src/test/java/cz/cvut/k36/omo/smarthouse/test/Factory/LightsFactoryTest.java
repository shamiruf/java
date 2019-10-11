/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.test.Factory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.FactoryCreator;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Lights;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class LightsFactoryTest {
    
    Lights lightsWithoutFactory = new Lights();

    public DeviceAbstract createLight() {
        
        AbstractFactory devicefactory = FactoryCreator.getFactory("Device");
        
        DeviceAbstract lightsWithFactory = devicefactory.getDevice("Lights");
        
        return lightsWithFactory;
        
    }
    
    @Test
    public void testLightsFactory() throws Exception {
        
    }
        
    
}
