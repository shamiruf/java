/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.test.Observer;

import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Lights;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.MotionSensor;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceOn;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class ObserverTest {
    
    Lights lights = new Lights();
    
    MotionSensor motionSensor = new MotionSensor();
    
    EventListener eventListener = new EventListener();
    
    @Before
    public void setLightsAndSensor() {
        
        lights.setEventListener(eventListener);
        
        lights.setSensor(motionSensor);
        
        motionSensor.informObserver();

    }
    
    @Test
    public void testLightsAndSensor(){
        
        assertEquals(lights.getDeviceState().getClass(), DeviceOn.class);
    }
    
}
