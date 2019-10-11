/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.chainofresponsibility;

/**
 *
 * @author admin
 */
public class SetUpChain {
    
    public static RequestHandler setUpChain() {
        
        RequestHandler womanHandler = new RequestToWoman();
        RequestHandler manHandler = new RequestToMan();
        RequestHandler childHandler = new RequestToChild();
        
        manHandler.setNextInChain(womanHandler);
        womanHandler.setNextInChain(childHandler);
        
        return manHandler;
    }
    
}
