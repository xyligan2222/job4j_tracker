package ru.job4j.profi;

import java.util.Calendar;

public class Engineer extends Profession {
    public double workExper;
    public double getWorkExper(){
        return workExper;
    }
    public Engineer (String name, String surname, String education, Calendar birthday){
        super(name, surname, education, birthday);
        this.workExper = workExper;
    }
    public Engineer(){
    }

}
