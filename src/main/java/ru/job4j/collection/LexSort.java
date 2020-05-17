package ru.job4j.collection;

        import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int firstString, secondString, firstNumber, secondNumber;
        firstString = left.indexOf('.');
        secondString = right.indexOf('.');

        firstNumber = Integer.parseInt(left, 0, firstString , 10);
        secondNumber = Integer.parseInt(right, 0, secondString , 10);
        return   Integer.compare(firstNumber, secondNumber);
    }
}