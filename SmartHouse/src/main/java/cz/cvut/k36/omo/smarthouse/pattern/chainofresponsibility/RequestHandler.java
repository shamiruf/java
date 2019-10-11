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
public abstract class RequestHandler {
    
    RequestHandler nextInChain;
    
    public abstract void request(String request);
    
    public void setNextInChain(RequestHandler nextInChain) {
        
        this.nextInChain = nextInChain;
    }
    
}
