/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.event;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Events {
    
    public List<String> action;
    
    public Events() {
        
        this.action = new ArrayList();
    }
    
    public int getAction() {
        
        int i = 0;
        
        for (String action : this.action) {
            
            i++;
        }
        
        return i;
    }
    
    public void printAction() {
        
        for (String action : this.action) {
            
            System.out.println(action);
        }
    }

}
