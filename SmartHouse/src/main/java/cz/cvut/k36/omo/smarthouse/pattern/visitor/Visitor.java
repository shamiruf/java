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
public interface Visitor {
    
    void visit(DeviceAbstract deviceAbstract);
    
    public void visit(Lights lights);
    
    public void visit(CDplayer cdplayer);
    
    public void visit(TV tv);
    
    public void visit(Computer computer);
    
    public void visit(Curtain curtain);
    
}
