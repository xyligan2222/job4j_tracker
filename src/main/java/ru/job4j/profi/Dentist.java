package ru.job4j.profi;

import java.util.Calendar;


public class Dentist extends Doctor {
    public double workExper;
    public String specialist;
    public double getWorkExper(){
        return workExper;
    }
    public String getSpecialist(){
        return specialist;
    }
    public Dentist (String name, String surname, String education, Calendar birthday){
        super(name, surname, education, birthday);
        this.specialist = specialist;
        this.workExper = workExper;
    }
    public Dentist(){
    }
    public void healTeeth(Patient patient) {
    }


}
