/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.visitor;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.CDplayer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Computer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Curtain;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Lights;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.TV;

/**
 *
 * @author admin
 */
public class TurnOnDevices implements Visitor{
    
    
    @Override
    public void visit(Lights lights) {
        
        if (lights.getDeviceState() == lights.deviceStateOff()){
            
            System.out.println("Lights are off, turning  on");
            lights.setDeviceState(lights.deviceStateOn());
            
        } else if (lights.getDeviceState() == lights.deviceStateOn()){
            
            System.out.println("Lights are already on");
        }
        
    }

    @Override
    public void visit(CDplayer cdplayer) {
        
        if (cdplayer.getDeviceState() == cdplayer.deviceStateOff()){
            
            System.out.println("CDplayer is off, turning it on");
            cdplayer.setDeviceState(cdplayer.deviceStateOn());
            
        } else if (cdplayer.getDeviceState() == cdplayer.deviceStateOn()){
            
            System.out.println("CDplayer is already on");
        }
        
    }

    @Override
    public void visit(TV tv) {
        
        if (tv.getDeviceState() == tv.deviceStateOff()){
            
            System.out.println("TV is off, turning it on");
            
        } else if (tv.getDeviceState() == tv.deviceStateOn()){
            
            System.out.println("TV is already on");
            tv.setDeviceState(tv.deviceStateOff());
        }
        
    }

    @Override
    public void visit(Computer computer) {
        
        if (computer.getDeviceState() == computer.deviceStateOff()){
            
            System.out.println("Computer is off, turning it on");
            computer.setDeviceState(computer.deviceStateOn());
            
        } else if (computer.getDeviceState() == computer.deviceStateOn()){
            
            System.out.println("Computer is already on");
            
        } else if (computer.getDeviceState() == computer.deviceStateSleep()){
            
            System.out.println("Computer sleep ");
            computer.setDeviceState(computer.deviceStateOn());
        }
        
    }
    
    @Override
    public void visit(DeviceAbstract deviceAbstract) {
        
        if (deviceAbstract.getDeviceState() == deviceAbstract.deviceStateOff()){
            
            System.out.println("Device is off, turning it on");
            deviceAbstract.setDeviceState(deviceAbstract.deviceStateOn());
            
        } else if (deviceAbstract.getDeviceState() == deviceAbstract.deviceStateOn()){
            
            System.out.println("Device is already on");
        }
        
    }


    @Override
    public void visit(Curtain curtain) {
        
        if (curtain.getDeviceState() == curtain.deviceStateOff()){
            
            System.out.println("Curtain is off, turning it on");
            curtain.setDeviceState(curtain.deviceStateOn());
            
        } else if (curtain.getDeviceState() == curtain.deviceStateOn()){
            
            System.out.println("Curtain is already on");
        }
        
    }
    
}
