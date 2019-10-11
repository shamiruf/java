/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.model;

import java.util.List;

/**
 *
 * @author admin
 */
public class Window implements HomeObject{
    
    public int windowNumber;


    public Window(int windowNumber) {
        
        this.windowNumber = windowNumber;
        
    }

    @Override
    public void setHomeObject(List area) {
        
    }

    @Override
    public List<?> getHomeObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(String print) {
        
        System.out.println(print);
       
    }
    
}
