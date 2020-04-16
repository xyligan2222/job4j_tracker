package ru.job4j.profi;

import java.util.Calendar;

public class Surgeon extends Doctor {
    public short category;
    public double perDeath;

    public short getCategory(){
        return category;
    }
    public double getPerDeath(){
        return perDeath;
    }
    public Surgeon (String name, String surname, String education, Calendar birthday){
        super(name, surname, education, birthday);
        this.category = category;
        this.perDeath = perDeath;
    }
    public Surgeon(){

    }
    public void healPatient(Patient patient) {
    }

}
