/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.visitor;

/**
 *
 * @author admin
 */
public interface Acceptor {
    
    void accept(Visitor visitor);
    
}
