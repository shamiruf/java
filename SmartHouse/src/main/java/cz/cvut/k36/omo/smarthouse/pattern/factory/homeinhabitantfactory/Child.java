/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.CDplayer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.lazyinitialization.DamageLevel;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Observer;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Sensor;

/**
 *
 * @author admin
 */
public class Child extends HomeInhabitantAbstract{
    
    DeviceAbstract deviceAbstract;
    
    Man man;
    
    public Child() {
        
        super();
    }

    @Override
    public void getName() {
        System.out.println("You created child ");
    }
    @Override
    public void getUpdate() {
        
        if (deviceAbstract.getDamageLevel() == DamageLevel.DAMAGE_IS_HARD) {
            
            System.out.println("Child tells father that the device has hard damage");
            man.menFixDevice();
            
        } else if (deviceAbstract.getDamageLevel() == DamageLevel.DAMAGE_IS_NORMAL) {
            
            System.out.println("Device can repair itself.");
            deviceAbstract.fixDevice();
            
        } else if (deviceAbstract.getDamageLevel() == DamageLevel.DAMAGE_CANNOT_BE_REPAIRED) {
            
            System.out.println("Child call father to fix the device.");
            man.menFixDevice();
        }

    }
    
    public void setSensor(Sensor sensor) {
        
        this.deviceAbstract = (DeviceAbstract) sensor;
        
        this.deviceAbstract.register((Observer) this);
    }
    
    public void insertCD(CDplayer cd) {
        
        api.insertCD(cd);
    }
    
}
