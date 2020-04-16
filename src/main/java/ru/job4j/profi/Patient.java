package ru.job4j.profi;

public class Patient {
    public String diagnose, name, surname;

    public String getDiagnose(){
        return diagnose;
    }
    public  String getName(){
        return name;
    }
    public  String getSurname(){
        return surname;
    }
    public Patient (String name, String surname, String diagnose){
        this.name = name;
        this.surname = surname;
        this.diagnose = diagnose;
    }
    public Patient (String name, String diagnose){
        this.name = name;
        this.diagnose = diagnose;
    }
    public Patient (){
    }
}
