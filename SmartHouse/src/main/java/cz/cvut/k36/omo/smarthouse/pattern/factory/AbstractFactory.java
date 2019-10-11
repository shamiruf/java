/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.pattern.factory;

import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.petfactory.PetAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory.VihicleAbstract;
/**
 *
 * @author admin
 */
public abstract class AbstractFactory {
    
    public abstract DeviceAbstract getDevice(String device);

    public abstract HomeInhabitantAbstract getHomeInhabitant(String homeInhabitant);

    public abstract VihicleAbstract getVihicle(String vihicle);
    
    public abstract PetAbstract getPet(String pet);
    
}
