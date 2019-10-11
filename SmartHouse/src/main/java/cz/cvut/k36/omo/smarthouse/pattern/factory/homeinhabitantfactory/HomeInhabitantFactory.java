/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.petfactory.PetAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory.VihicleAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory.VihicleFactory;

/**
 *
 * @author admin
 */
public class HomeInhabitantFactory extends AbstractFactory  {

    @Override
    public DeviceAbstract getDevice(String device) {
        return null;
    }

    @Override
    public HomeInhabitantAbstract getHomeInhabitant(String homeInhabitant) {
        
        if (homeInhabitant == null) {
            
            return null;
        }
        
        if (homeInhabitant.equalsIgnoreCase("Woman")) {
            
            return new Woman();
            
        } else if (homeInhabitant.equalsIgnoreCase("Man")) {
            
            return new Man();
            
        } else if (homeInhabitant.equalsIgnoreCase("Child")) {
            
            return new Child();
        }
        
        return null;
        
    }

    @Override
    public VihicleAbstract getVihicle(String vihicle) {
        
        return null;
        
    }

    @Override
    public PetAbstract getPet(String pet) {
        
        return null;
    }
    
}
