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
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceOff;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceOn;
import cz.cvut.k36.omo.smarthouse.pattern.statemachine.DeviceSleep;

/**
 *
 * @author admin
 */
public class TurnOffDevices implements Visitor{


    @Override
    public void visit(Lights lights) {
        
        if (lights.deviceState.getClass() == DeviceOff.class){
            
            System.out.println("Lights are already off");
            
        } else if (lights.deviceState.getClass() == DeviceOn.class){
            
            System.out.println("Lights are on, turning  off");
            lights.setDeviceState(lights.deviceStateOff());
        }
    }

    @Override
    public void visit(CDplayer cdplayer) {
        
        if (cdplayer.deviceState.getClass() == DeviceOff.class){
            
            System.out.println("CDplayer is already off");
            
        } else if (cdplayer.deviceState.getClass() == DeviceOn.class){
            
            System.out.println("CDplayer is on, turning it off");
            cdplayer.setDeviceState(cdplayer.deviceStateOff());
        }
        
    }

    @Override
    public void visit(TV tv) {
        
        if (tv.deviceState.getClass() == DeviceOff.class){
            
            System.out.println("TV is already off");
            
        } else if (tv.deviceState.getClass() == DeviceOn.class){
            
            System.out.println("TV is on, turning it off");
            tv.setDeviceState(tv.deviceStateOff());
        }
        
    }

    @Override
    public void visit(Computer computer) {
        
        if (computer.deviceState.getClass() == DeviceOff.class){
            
            System.out.println("Computer is already off");
            
        } else if (computer.deviceState.getClass() == DeviceOn.class){
            
            System.out.println("Computer is on, turning it off");
            computer.setDeviceState(computer.deviceStateOff());
            
        } else if (computer.deviceState.getClass() == DeviceSleep.class){
            
            System.out.println("Computer sleep ");
            computer.setDeviceState(computer.deviceStateOff());
        }
        
    }

    @Override
    public void visit(DeviceAbstract deviceAbstract) {
        
        if (deviceAbstract.deviceState.getClass() == DeviceOff.class){
            
            System.out.println("Device is already off");
            
        } else if (deviceAbstract.deviceState.getClass() == DeviceOn.class){
            
            System.out.println("Device is on, turning it off");
            deviceAbstract.setDeviceState(deviceAbstract.deviceStateOff());
        }
        
    }

    @Override
    public void visit(Curtain curtain) {
        
        if (curtain.deviceState.getClass() == DeviceOff.class){
            
            System.out.println("Curtain is already off");
            
        } else if (curtain.deviceState.getClass() == DeviceOff.class){
            
            System.out.println("Curtain is on, turning it off");
            curtain.setDeviceState(curtain.deviceStateOff());
        }
    }
    
}
