/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.statemachine;

/**
 *
 * @author admin
 */
public interface DeviceState {
    
    void off();
    
    void on();
    
    void sleep();
    
}
