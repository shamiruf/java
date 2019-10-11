/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class HouseConfiguration {
    
    Home home = Home.getHome();
    
    List<Floor> floors = new ArrayList<>();
    
    Floor floor1 = new Floor(1);
    Floor floor2 = new Floor(2);
    
    List<Room> rooms1 = new ArrayList<>();
    List<Room> rooms2 = new ArrayList<>();
    
    Room bedroom1 = new Room("bedroom");
    Room bedroom2 = new Room("living room");
    Room bedroom3 = new Room("bathroom");
    Room bedroom4 = new Room("kitchen");
    Room bedroom5 = new Room("guest room");
    Room bedroom6 = new Room("dining room");
    
    
    
    List<Window> windows1 = new ArrayList<>();
    List<Window> windows2 = new ArrayList<>();
    List<Window> windows4 = new ArrayList<>();
    List<Window> windows5 = new ArrayList<>();
    List<Window> windows6 = new ArrayList<>();
    
    Window window1 = new Window(1);
    Window window2 = new Window(2);
    Window window3 = new Window(3);
    Window window4 = new Window(4);
    Window window5 = new Window(5);
    Window window6 = new Window(6);
    Window window7 = new Window(7);
    Window window8 = new Window(8);
    Window window9 = new Window(9);
    Window window10 = new Window(10);
    
    private void createHome(){
        
        home.setHomeObject(floors);
        
        floors.add(floor1);
        floors.add(floor2);
        
        floor1.setHomeObject(rooms1);
        floor2.setHomeObject(rooms2);
        
        rooms1.add(bedroom4);
        rooms1.add(bedroom5);
        rooms1.add(bedroom6);
        rooms2.add(bedroom1);
        rooms2.add(bedroom2);
        rooms2.add(bedroom3);
        
        bedroom1.setHomeObject(windows1);
        bedroom2.setHomeObject(windows2);
        bedroom4.setHomeObject(windows4);
        bedroom5.setHomeObject(windows5);
        bedroom6.setHomeObject(windows6);

        windows1.add(window1);
        windows1.add(window2);
        windows2.add(window3);
        windows2.add(window4);
        windows2.add(window5);
        windows4.add(window6);
        windows5.add(window7);
        windows6.add(window8);
        windows6.add(window9);
        windows6.add(window10);
        
        }
    
    public HouseConfiguration() {
        
        this.createHome();
        
    }
    
    public Room getBedroom1() {
        return bedroom1;
    }

    public void setBedroom1(Room bedroom1) {
        this.bedroom1 = bedroom1;
    }

    public Room getBedroom2() {
        return bedroom2;
    }

    public void setBedroom2(Room bedroom2) {
        this.bedroom2 = bedroom2;
    }

    public Room getBedroom3() {
        return bedroom3;
    }

    public void setBedroom3(Room bedroom3) {
        this.bedroom3 = bedroom3;
    }

    public Room getBedroom4() {
        return bedroom4;
    }

    public void setBedroom4(Room bedroom4) {
        this.bedroom4 = bedroom4;
    }

    public Room getBedroom5() {
        return bedroom5;
    }

    public void setBedroom5(Room bedroom5) {
        this.bedroom5 = bedroom5;
    }
    
    public Room getBedroom6() {
        return bedroom6;
    }

    public void setBedroom6(Room bedroom6) {
        this.bedroom6 = bedroom6;
    }
    
    public void printHouseConfiguration(){
        
        System.out.println("Configuration of " + home.homeName 
                + " house, house number is " + home.homeNumber 
                + " , house adress is " + home.homeAdress);

            for (Floor floor : home.getHomeObject()) {
                
                floor.print(" Floor: " + floor.floorNumber);
                
                if (floor.getHomeObject() != null) {
                    
                    for (Room room : floor.getHomeObject()){
                        
                        room.print(" Room: " + room.roomName);
                        
                        if (room.getHomeObject() == null) {
                            
                            System.out.println(" No window in this room ");
                            
                        } else {
                            
                            for (Window window : room.getHomeObject()) {
                                
                                window.print(" Window: " + window.windowNumber);
                                
                            }
                            
                        }
                        
                    }
                } else {
                    
                    System.out.println(" No rooms in this floor ");
                    
                }
            }
    }
    
}
