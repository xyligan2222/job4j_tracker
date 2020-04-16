package ru.job4j.profi;

import java.util.Calendar;

public class Doctor extends Profession {
    public boolean diplomMed;

    public boolean isDiplomMed(){
        return diplomMed;
    }
    public Doctor(String name, String surname, String education, Calendar birthday){
        super(name, surname, education, birthday);
        this.diplomMed = diplomMed;
    }
    public Doctor (String name, String surname, String education){
        super(name, surname, education);
        this.diplomMed = diplomMed;
    }
    public Doctor(){
    }
}
