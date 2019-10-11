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
public class Home implements HomeObject{
    
    public String homeNumber;
    
    public String homeAdress;
    
    public String homeName;
    
    List<Floor> floor;
    
    public Home(String homeName, String homeNumber, String homeAdress) {
        
        this.homeName = homeName;
        
        this.homeNumber = homeNumber;
        
        this.homeAdress = homeAdress;
        
    }
    
    @Override
    public void setHomeObject(List area) {
        
        this.floor = area;
        
    }

    @Override
    public List<Floor> getHomeObject() {
        
        return floor;
    }

    @Override
    public void print(String print) {
        
        System.out.println(print);
        
    }
    
    private static class Singleton{
        
        private static final Home home_instance = new Home("Shamikh's", "1838/46",
                "Jindrisska street");
        
    }
    
    public static Home getHome(){
        
        return Singleton.home_instance;
        
    }
    
}
