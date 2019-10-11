/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.petfactory.PetAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory.VihicleAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory.VihicleFactory;

/**
 *
 * @author admin
 */
public class DeviceFactory extends AbstractFactory{

    @Override
    public DeviceAbstract getDevice(String device) {
        
        if (device == null) {
            
            return null; 
        }
        
        if(device.equalsIgnoreCase("Lights")){
            
            return new Lights();
            
        } else if(device.equalsIgnoreCase("CDplayer")){
            
            return new CDplayer();
            
        } else if(device.equalsIgnoreCase("TV")){
            
            return new TV();
            
        } else if(device.equalsIgnoreCase("Computer")) {
            
            return new Computer();
        }
        
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
        
        return null;
    }
    
}
