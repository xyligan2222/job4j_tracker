package ru.job4j.inheritance;

public class Config {
    private String name;
    private int position;
    private String[] properties;

    private Config(String name) {
        this.name = name;
    }

    void print() {
        System.out.println(position);
    }

    private String getProperty(String key) {
        return search(key);
    }

    private String search(String key) {
        return key;
    }
}