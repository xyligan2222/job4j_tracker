package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
    Fact fact = new Fact();
        System.out.println(fact.calc(3));
        System.out.println(fact.calc(-3));
    }

    public int calc(int n) {
        if (n < 0 ){
            throw new IllegalArgumentException("number must be positive");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}