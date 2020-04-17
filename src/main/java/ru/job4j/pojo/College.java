package ru.job4j.pojo;

import java.sql.SQLOutput;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student first = new Student();
        first.setName("Frol");
        first.setGroup("ANM-16");
        first.setCreated(new Date());

        System.out.println(first.getName() + " group " + first.getGroup() + " the current date " + first.getCreated());
    }
}
