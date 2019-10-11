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
public class RequestToMan extends RequestHandler {

    @Override
    public void request(String request) {
        
        if (request.equalsIgnoreCase("Man")) {
            
            System.out.println("Milush want food");
            System.out.println("I do it " + request);

        } else {
            
            System.out.println("Man doesn't want anything. Who want is "  + request);
            
            if (nextInChain != null) {
                
                nextInChain.request(request);
            }
        }
    }
    
}
