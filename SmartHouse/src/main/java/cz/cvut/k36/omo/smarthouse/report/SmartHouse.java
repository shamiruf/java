/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.smarthouse.report;

import cz.cvut.k36.omo.smarthouse.model.HouseConfiguration;
import cz.cvut.k36.omo.smarthouse.pattern.chainofresponsibility.RequestHandler;
import static cz.cvut.k36.omo.smarthouse.pattern.chainofresponsibility.SetUpChain.setUpChain;
import cz.cvut.k36.omo.smarthouse.pattern.event.EventListener;
import cz.cvut.k36.omo.smarthouse.pattern.factory.AbstractFactory;
import cz.cvut.k36.omo.smarthouse.pattern.factory.FactoryCreator;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.CDplayer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Computer;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Curtain;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.DeviceAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.Lights;
import cz.cvut.k36.omo.smarthouse.pattern.factory.devicefatory.TV;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.Child;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.HomeInhabitantAbstract;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.Man;
import cz.cvut.k36.omo.smarthouse.pattern.factory.homeinhabitantfactory.Woman;
import cz.cvut.k36.omo.smarthouse.pattern.factory.vihiclefactory.Bicycle;
import cz.cvut.k36.omo.smarthouse.pattern.lazyinitialization.DamageLevel;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.MotionSensor;
import cz.cvut.k36.omo.smarthouse.pattern.observer.sensor.Sensor;

/**
 *
 * @author admin
 */
public class SmartHouse {
    
    public static void main(String[] args) {
        
        HouseConfigurationReport report = new HouseConfigurationReport();
        
        report.DocGenerator();
        
        System.out.println("Report was generated");
        System.out.println(" !!! ");
        System.out.println("House configuration from another class.");
        
        HouseConfiguration home = new HouseConfiguration();
        
        home.printHouseConfiguration();
        
        System.out.println("!!!");
        System.out.println("Creating child with factory ");
        
        AbstractFactory humanfactory = FactoryCreator.getFactory("HomeInhabitant");
        
        HomeInhabitantAbstract child = humanfactory.getHomeInhabitant("Child");
        
        child.getName();
        
        System.out.println("!!!");
        System.out.println("Creating : event listener, sensor, device using factory");
        
        
        EventListener eventListener = new EventListener();
        MotionSensor motionSensor = new MotionSensor();
        
        
        AbstractFactory device = FactoryCreator.getFactory("Device");
        DeviceAbstract lights = device.getDevice("lights");
        lights.setEventListener(eventListener);
        
        System.out.println(" !!! ");
        System.out.println("Child turn on lights. (API, Visitor design patteren) ");
        
        child.on((Lights) lights);
        
        System.out.println("!!!");
        System.out.println("Child turn on lights. (API, Visitor design patteren) ");
        
        child.off((Lights) lights);
        ((Lights) lights).setSensor(motionSensor);
        
        System.out.println(" !!! ");
        
        System.out.println("Sensor send notification to light. ");
        
        motionSensor.informObserver();
        
        System.out.println(" !!! ");
        System.out.println("Event listener print report. (Save in root folder) ");
        
        eventListener.printAction(); 
        eventListener.DocGenerator();
        
        System.out.println(" !!! ");
        System.out.println(" !!! ");

        System.out.println("State design pattern");
        
        CDplayer cdplayer2 = new CDplayer();
        
        cdplayer2.deviceStateOff();
        
        Child child1 = new Child();
        
        System.out.println("Child turn on cdplayer");
        
        cdplayer2.deviceStateOn();
        cdplayer2.deviceStateOff();
        
        System.out.println(" !!! ");
        
        System.out.println("Chain of responsibility");
        
        System.out.println("Milus is cat. He wants eat. ");
        
        RequestHandler chain;
        
        chain = setUpChain();
        chain.request("child");


        System.out.println(" Lazy initialization desigh pattern ");
        
        
        
        CDplayer cdplayer = new CDplayer();
        cdplayer.breakDevice(DamageLevel.DAMAGE_IS_HARD);
        System.out.println("The cdplayer has a hard damage. Repair it.");
        cdplayer.fixDevice();
        
        TV tv = new TV();
        tv.breakDevice(DamageLevel.DAMAGE_CANNOT_BE_REPAIRED);
        System.out.println("The TV was totally broken. ");
        tv.fixDevice();

        Computer computer1 = new Computer();
        computer1.breakDevice(DamageLevel.DAMAGE_IS_NORMAL);
        System.out.println("The computer has a normal damge. Repair it. ");
        computer1.fixDevice();

        

        System.out.println("Using vihicle. ");

        Man man = new Man();
        Child child2 = new Child();
        Child child3 = new Child();
        Woman woman = new Woman();

        Bicycle bicycle = new Bicycle();

        bicycle.useVihicle(man);
        bicycle.useVihicle(woman);
        bicycle.useVihicle(child2);
        bicycle.useVihicle(child3);

        bicycle.setFree();
        bicycle.setFree();
        bicycle.setFree();
        bicycle.setFree();
        

        System.out.println(" !!! ");
        System.out.println("Consumption report. ");
        
        TV tv1 = new TV();
        Curtain curtain = new Curtain();

        System.out.println("Turn on devices.");
        
        tv1.deviceStateOn();
        curtain.deviceStateOn();

        System.out.println("Create consumption report.");
        
        ConsumptionReport consumptionReport = new ConsumptionReport();
        
        
        consumptionReport.addDevice(tv1);
        consumptionReport.addDevice(curtain);
        consumptionReport.addDevice(lights);
        consumptionReport.addDevice(cdplayer);

        System.out.println("Turn off devices.");
        
        tv1.deviceStateOff();
        lights.deviceStateOff();
        curtain.deviceStateOff();
        cdplayer.deviceStateOff();
        
        consumptionReport.generateDoc();
        
        
        System.out.println(" !!! ");
        System.out.println("Activity and usage report");

        ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport();
        
        activityAndUsageReport.addDevice(lights);
        activityAndUsageReport.addDevice(curtain);
        activityAndUsageReport.addDevice(cdplayer);
        activityAndUsageReport.addDevice(tv1);
        
        activityAndUsageReport.docGenerator();
        
        System.out.println("Check out ActivityAndUsageReport.txt file.");
        

        System.out.println(" !!! ");
        System.out.println("Event report. ");

        child1.setSensor(tv);
        tv.breakDevice(DamageLevel.DAMAGE_IS_NORMAL);

        woman.setSensor(cdplayer);
        cdplayer.breakDevice(DamageLevel.DAMAGE_IS_HARD);
        
        Computer computer = new Computer();

        man.setSensor(computer);
        computer.breakDevice(DamageLevel.DAMAGE_CANNOT_BE_REPAIRED);

        EventReport eventReport = new EventReport();
        
        eventReport.addDevice(tv);
        eventReport.addDevice(cdplayer);
        eventReport.addDevice(computer);
        
        eventReport.docGenerator();
        
        System.out.println("Check out EventReport.txt file.");


    }
    
}
