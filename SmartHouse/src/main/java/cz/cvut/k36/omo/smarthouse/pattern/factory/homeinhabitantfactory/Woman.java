/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.lazyinitialization.DamageLevel;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Observer;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Sensor;

/**
 *
 * @author admin
 */
public class Woman extends HomeInhabitantAbstract{
    
    DeviceAbstract deviceAbstract;
    
    Man man;
    
    public Woman() {
        
        super();
    }

    @Override
    public void getName() {
        
        System.out.println("You created woman ");
    }
    
    public void serviceFixDevice(){
        
        deviceAbstract.fixDevice();
        
        System.out.println("Service fixed problem ");
    }
    @Override
    public void getUpdate() {
        
        if (deviceAbstract.getDamageLevel() == DamageLevel.DAMAGE_IS_HARD) {
            
            System.out.println("Woman calls to the service.");
            serviceFixDevice();
            
        } else if (deviceAbstract.getDamageLevel() == DamageLevel.DAMAGE_IS_NORMAL) {
            
            System.out.println("Device can repair itself.");
            deviceAbstract.fixDevice();
            
        } else if (deviceAbstract.getDamageLevel() == DamageLevel.DAMAGE_CANNOT_BE_REPAIRED) {
            
            System.out.println("Women tell men to buy a new device.");
            man.menFixDevice();
        }

    }
    
    public void setSensor(Sensor sensor) {
        
        this.deviceAbstract = (DeviceAbstract) sensor;
        
        this.deviceAbstract.register((Observer) this);
    }
    
    
    
}
