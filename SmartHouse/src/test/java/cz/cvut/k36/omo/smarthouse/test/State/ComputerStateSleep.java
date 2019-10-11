/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.test.State;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Computer;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceSleep;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class ComputerStateSleep {
    
    Computer computer;
    
    @Before
    public void setState(){
        
        computer = new Computer();
        
        computer.deviceStateOn();
        
        computer.deviceStateSleep();
        
    }

    @Test
    public void testState(){
        
        assertEquals(computer.deviceState.getClass(), DeviceSleep.class);
    }
    
}
