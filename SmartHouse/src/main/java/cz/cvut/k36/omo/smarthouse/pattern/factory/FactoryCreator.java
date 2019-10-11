/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory.VihicleFactory;

/**
 *
 * @author admin
 */
public class FactoryCreator {
    
    public static AbstractFactory getFactory(String choice) {
        
        if (choice.equalsIgnoreCase("Device")) {
            
            return new DeviceFactory();
            
        } else if (choice.equalsIgnoreCase("HomeInhabitant")) {
            
            return new HomeInhabitantFactory();
            
        } else if (choice.equalsIgnoreCase("Vihicle")) {
            
            return new VihicleFactory();
            
        }
        return null;
        
    }
        
}
