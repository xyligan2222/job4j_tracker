package ru.job4j.profi;

import java.util.Calendar;

public class Builder extends Engineer {
    public String specialty, citizenship;

    public String getCitizenship(){
        return citizenship;
    }
    public String getSpecialty(){
        return specialty;
    }
    public Builder(String name, String surname, String education, Calendar birthday){
        super(name, surname, education, birthday);
        this.citizenship = citizenship;
        this.specialty = specialty;
    }
    public Builder(){

    }
    public void houseBuild(Project project){

    }
}
