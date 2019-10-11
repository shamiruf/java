/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import java.util.LinkedList;

/**
 *
 * @author admin
 */
public abstract class VihicleAbstract extends DeviceAbstract {
    
    private boolean isBusy;
    
    private HomeInhabitantAbstract userVihicle;
    
    private LinkedList<HomeInhabitantAbstract> queueOnVihicle;
    
    public VihicleAbstract() {
        
        this.isBusy = false;
        
        this.queueOnVihicle = new LinkedList<>();
    }
    
    public HomeInhabitantAbstract getUserVihicle() {
        
        return userVihicle;
    }
    
    public void useVihicle(HomeInhabitantAbstract inh) {
        
        if (isBusy) {
            
            queueOnVihicle.add(inh);
            return;
        }
        
        userVihicle = inh;
        isBusy = true;
        
        System.out.println(this.getClass().getSimpleName() + " is used by " 
                + getUserVihicle());
        
    }
    
    public void setFree(){
        
        isBusy = false;
        
        if (!queueOnVihicle.isEmpty()) {
            
            useVihicle(queueOnVihicle.getFirst());
            queueOnVihicle.remove(queueOnVihicle.getFirst());
        }
        
        userVihicle = null;
        
        System.out.println(this.getClass().getSimpleName() + " is free now ");
        
    }
    
    

    
    
    
}
