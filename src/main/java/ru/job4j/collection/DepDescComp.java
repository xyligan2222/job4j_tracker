package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] firstString, secondString;
        firstString  = o1.split("/");
        secondString = o2.split("/");
        return secondString[0].compareTo(firstString[0]) == 0 ? o1.compareTo(o2) : secondString[0].compareTo(firstString[0]);
    }
}