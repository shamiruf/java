/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.test.Singleton;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.TV;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 *
 * @author admin
 */
public class TVSingletonTest {
    
    TV tv1;
    
    TV tv2;
    
    
    @Before
    public void setTV(){
        
        tv1 = new TV();
            
        tv2 = new TV();
    }


    @Test
    public void testTVSingleton(){
        
        assertNotEquals(tv1, tv2);
    }
    
}
