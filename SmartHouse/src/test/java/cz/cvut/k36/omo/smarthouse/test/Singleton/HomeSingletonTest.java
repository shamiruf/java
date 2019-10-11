/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.test.Singleton;

import cz.cvut.k36.omo.smarthouse.model.Home;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class HomeSingletonTest {
    
    Home home1;
    
    Home home2;

    @Before
    public void setHouse(){
        
        home1 = Home.getHome();
        
        home2 = Home.getHome();
        
    }

    @Test
    public void testHouseSingleton(){
        
        assertEquals(home1,home2);
        
    }
    
}
