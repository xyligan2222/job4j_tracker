package ru.job4j.collection;

import java.util.ArrayList;


public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (String value: names) {
            System.out.println(value);
        }

        for (int i = 0; i <names.size() ; i++) {
            System.out.println(names.get(i));
        }
    }
}
