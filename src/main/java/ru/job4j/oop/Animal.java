package ru.job4j.oop;

public class Animal {
    public Animal() {
        super();
        System.out.println("Tiiiiiiiger");
    }
    public Animal(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Predator predator = new Predator("Tigers");
        Tiger tiger = new Tiger("BigBoss");
    }
}
