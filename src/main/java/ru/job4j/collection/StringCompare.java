package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char x, y;
        int result = 0;
        int size = Math.min(left.length(), right.length());

            for (int i = 0; i < size ; i++) {
                x = left.charAt(i);
                y = right.charAt(i);
                result = Character.compare( x, y);
                if (result != 0) {
                    break;
                }
            }
        return result == 0 ? Integer.compare(left.length(),right.length()) : result;
    }
}
