/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory;

import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;
import cz.cvut.k36.omo.smarthouse.pattern.lazyinitialization.DamageLevel;
import cz.cvut.k36.omo.smarthouse.pattern.lazyinitialization.Documentation;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Observer;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Sensor;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceOff;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceState;
import cz.cvut.k36.omo.smarthouse.pattern.visitor.Acceptor;
import cz.cvut.k36.omo.smarthouse.pattern.visitor.Visitor;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author admin
 */

public abstract class DeviceAbstract implements Acceptor, Sensor{
    
    private int activity = 0;
    
    private final int power;
    
    private static final int DEFAULT_POWER = 100;
    
    private int beginOfTime;
    private int endOfTime;
    private int actualTime;
    
    private final double consumpCost;
    
    private static final double DEFAULT_CONSUMP_COST = 0.17;
    
    public DeviceState deviceState;
    
    EventListener eventListener;
    
    private int currentHealth;
    
    private static final int MAX_VALUE = 6;
    
    private Documentation documentation;
    
    private DamageLevel damageLevel = DamageLevel.DEVICE_IS_OK;
    
    private List<Observer> observers = new LinkedList<Observer>();
    
    
    private static final int MILLISECONDS_IN_HOUR = 3600000;
    
    public DeviceAbstract() {
        
        this.currentHealth = MAX_VALUE;
        
        this.power = DEFAULT_POWER;
        
        this.consumpCost = DEFAULT_CONSUMP_COST;
        
        this.actualTime = 0;
        
        this.deviceState = new DeviceOff(this);
        
        this.activity = 0;
    }
    
    public DeviceAbstract(int power, int consumpCost) {
        
        this.currentHealth = MAX_VALUE;
        
        this.power = power;
        
        this.consumpCost = consumpCost;
        
        this.actualTime = 0;
        
        this.deviceState = new DeviceOff(this);
    }
    
    public void wearOut() {
        
        activity++;
        currentHealth -= 1;
        
        if (currentHealth >= 3) {
            System.out.println(this.getClass().getSimpleName() + " is still ok.");
        } else if (currentHealth == 2) {
            breakDevice(DamageLevel.DAMAGE_IS_NORMAL);
            System.out.println(this.getClass().getSimpleName() + " is pretty damaged right now.");
        } else if (currentHealth == 1) {
            breakDevice(DamageLevel.DAMAGE_IS_HARD);
            System.out.println(this.getClass().getSimpleName() + " is highly damaged right now.");
        } else if (currentHealth == 0) {
            breakDevice(DamageLevel.DAMAGE_CANNOT_BE_REPAIRED);
            System.out.println(this.getClass().getSimpleName() + " is broken right now. You can't use it anymore.");
        }
    }
    
    
    public double calcTime() {
        
        long oneSession = endOfTime - beginOfTime;
        
        this.actualTime += oneSession;
        
        return actualTime;
        
    }
    
    public double calcTotalConsumpCost() {
        
        return power * calcTime() * consumpCost / MILLISECONDS_IN_HOUR;
        
    }
    
    public double calcTotalConsump() {
        
        return power * calcTime()  / MILLISECONDS_IN_HOUR;
        
    }
    
    public DeviceState getDeviceState() {
        
        return deviceState;
    }

    public void setDeviceState(DeviceState deviceState) {
        System.out.println("YA V SETDEVICESTATE");
        this.deviceState = deviceState;
        
        
    }
    
    public EventListener getEventListener() {
        
        return eventListener;
    }

    public void setEventListener(EventListener eventListener) {
        
        this.eventListener = eventListener;
    }
    
    public void fixDevice() {

        this.currentHealth = MAX_VALUE;

        if (documentation == null)
            
            documentation = new Documentation();
        
        if (damageLevel == DamageLevel.DAMAGE_IS_HARD) {
            
            documentation.repairWithService();
            
        } else if (damageLevel == DamageLevel.DAMAGE_IS_NORMAL) {
            
            documentation.repairItself();
            
        } else if (damageLevel == DamageLevel.DAMAGE_CANNOT_BE_REPAIRED) {
            
            documentation.buyNewDevice();
        }
        
        System.out.println(this.getClass().getSimpleName() + " was completely repaired.");
    }
    
    public DamageLevel getDamageLevel() {
        
        return damageLevel;
    }

    public void setDamageLevel(DamageLevel damageLevel) {
        
        this.damageLevel = damageLevel;
    }
    
    public void register(Observer observer){
        
        observers.add(observer);
    }
    
    public void unregister(Observer observer){
        
        observers.remove(observer);
    }
    
    @Override
    public void accept(Visitor visitor) {
        
        visitor.visit(this);
    }
    
    public DeviceState deviceStateOff() {
        
        this.deviceState.off();
        
        this.endOfTime = (int) System.currentTimeMillis();
        
        return this.deviceState;
    }
    
    public DeviceState deviceStateOn() {
        
        this.deviceState.on();
        
        this.beginOfTime = (int) System.currentTimeMillis();
        wearOut();
        return this.deviceState;
        
    }
    
    public DeviceState deviceStateSleep() {
        
        this.deviceState.sleep();
        
        return this.deviceState;
    }
    
    public void breakDevice(DamageLevel state) {
        
        if (state == DamageLevel.DEVICE_IS_OK) {
            
            throw new IllegalArgumentException("Can not break device. ");
        }
        
        this.damageLevel = state;
    }
    
    public Documentation getDocumentation() {
        
        return this.documentation;
    }
    
    public void setDocumentation(Documentation documentation) {
        
        this.documentation = documentation;
    }
    
    public int getCurrentHealth() {
        
        return currentHealth;
    }
    
    public void setCurrentHealth(int currentHealth) {
        
        this.currentHealth = currentHealth;
    }
    
    public long getActualTime() {
        
        return actualTime;
    }
    
    public void setActualTime(int actualTime) {
        
        this.actualTime = actualTime;
    }
    
    public int getPower() {
        
        return power;
    }
    
    public int getActivity() {
        
        return activity;
    }

    public void setActivity(int activity) {
        
        this.activity = activity;
    }

    public void addObserver(Observer o) {
        
        observers.add(o);
        
    }

    public void deleteObserver(Observer o) {
        
        observers.remove(o);
        
    }

    public void informObserver() {
        
        for (Observer observer : observers){
            
            observer.getUpdate();
        }
        
    }

}
