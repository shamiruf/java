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
public class Man extends HomeInhabitantAbstract{
    
    DeviceAbstract deviceAbstract;

    public void menFixDevice(){
        
        deviceAbstract.fixDevice();
        
        System.out.println("Men fixed problem ");
    }
    
    @Override
    public void getUpdate() {
        
        if (deviceAbstract.getDamageLevel() == DamageLevel.DAMAGE_IS_HARD) {
            
            System.out.println("Man is going to repair the device.");
            menFixDevice();
            
        } else if (deviceAbstract.getDamageLevel() == DamageLevel.DAMAGE_IS_NORMAL) {
            
            System.out.println("Device can repair itself.");
            deviceAbstract.fixDevice();
            
        } else if (deviceAbstract.getDamageLevel() == DamageLevel.DAMAGE_CANNOT_BE_REPAIRED) {
            
            System.out.println("Man has to buy a new device.");
            menFixDevice();
        }

    }
    
    @Override
    public void getName() {
        
        System.out.println("You created man ");
    }
    
    public void setSensor(Sensor sensor) {
        
        this.deviceAbstract = (DeviceAbstract) sensor;
        
        this.deviceAbstract.register((Observer) this);
    }

    
}
