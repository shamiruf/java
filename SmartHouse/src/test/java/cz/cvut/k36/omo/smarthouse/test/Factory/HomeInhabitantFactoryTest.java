/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.test.Factory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.FactoryCreator;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.Man;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class HomeInhabitantFactoryTest {
    
    
    
    public HomeInhabitantAbstract createMan(){
        
        AbstractFactory homeInhabitant =  FactoryCreator.getFactory("HomeInhabitant");
        HomeInhabitantAbstract man = homeInhabitant.getHomeInhabitant("Man");
        return man;
    }
    
    Man manWithoutFactory = new Man();

    @Test
    public void test1() throws Exception {
        
        assertEquals(manWithoutFactory.getClass(), createMan().getClass());

    }

    
}
