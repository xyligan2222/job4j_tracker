package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        int length = end - start;
        if (end >= start) {
            for (int i = 0; i <= length; i++) {
            rsl.add(func.apply((double) start));
            start++;
            }
        }
        return rsl;
    }
}
