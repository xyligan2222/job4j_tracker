package ru.job4j.profi;

import java.util.Calendar;

public class Programmer extends Engineer {
    public String lang, position;

    public String getLang(){
        return lang;
    }
    public String getPosition(){
        return position;
    }
    public Programmer (String name, String surname, String education, Calendar birthday){
        super(name, surname, education, birthday);
        this.lang = lang;
        this.position = position;
    }
    public Programmer(){
    }
    public void developDataBase(Project project){
    }

}
