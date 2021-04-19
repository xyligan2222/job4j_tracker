package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int i = 0; i < row.length ;i++) {
                list.add(row[i]);
            }
        }
        return list;
    }
}