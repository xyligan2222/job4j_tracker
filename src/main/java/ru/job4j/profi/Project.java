package ru.job4j.profi;

import java.util.Calendar;

public class Project {
    public String name, description;
    public Calendar dataOn, dataOff;

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Calendar getDataOn(){
        return dataOn;
    }
    public Calendar getDataOff(){
        return dataOff;
    }
    public  Project (String name, String description, Calendar dataOn, Calendar dataOff){
        this.name = name;
        this.description = description;
        this.dataOn = dataOn;
        this.dataOff = dataOff;
    }
    public  Project (String name, String description, Calendar dataOn){
        this.name = name;
        this.description = description;
        this.dataOn = dataOn;
    }
    public  Project (String name, String description){
        this.name = name;
        this.description = description;
    }
    public  Project (String name){
        this.name = name;
    }
    public  Project (){
    }
}
