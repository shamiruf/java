/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.petfactory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory.VihicleAbstract;

/**
 *
 * @author admin
 */
public class PetFactory extends AbstractFactory{

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
        
        return null;
        
    }

    @Override
    public PetAbstract getPet(String pet) {
        
        if(pet == null){
            
            return null;
        }
        
        if(pet.equalsIgnoreCase("Cat")){
            
            return new Cat();
            
        } else if(pet.equalsIgnoreCase("Dog")){
            
            return new Dog();
            
        } else if(pet.equalsIgnoreCase("Hamster")){
            
            return new Hamster();
        }
        
        return null;
    }
}
