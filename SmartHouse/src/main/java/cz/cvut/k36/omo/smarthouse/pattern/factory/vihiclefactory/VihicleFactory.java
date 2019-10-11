/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.petfactory.PetAbstract;

/**
 *
 * @author admin
 */
public class VihicleFactory extends AbstractFactory{

    @Override
    public DeviceAbstract getDevice(String device) {
        
        return null;
    }

    @Override
    public HomeInhabitantAbstract getHomeInhabitant(String homeInhabitant) {
        
        return null;
    }

    @Override
    public VihicleAbstract getVihicle(String vihicle) {
        
        if(vihicle == null){
            
            return null;
        }
        
        if(vihicle.equalsIgnoreCase("Bycicle")){
            
            return new Bicycle();
            
        } else if (vihicle.equalsIgnoreCase("Car")){
            
            return new Car();
        } 
        
        return null;
    }

    @Override
    public PetAbstract getPet(String pet) {
        
        return null;
    }
    
}
