package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char x, y;
        int result = 0;
        int size = left.length() - right.length();
        if (size > 0) {
            size = right.length();
        } else {
            size = left.length();
        }
            for (int i = 0; i < size ; i++) {
                x = left.charAt(i);
                y = right.charAt(i);
                result = Character.compare( x, y);
                if (result != 0) {
                    return result;
                }
                if (i == size - 1 && result == 0 && left.length() > right.length()) {
                    return result = 1;
                }
                if (i == size - 1 && result == 0 && left.length() < right.length()) {
                    return result = -1;
                }
            }


        return result;
    }
}
