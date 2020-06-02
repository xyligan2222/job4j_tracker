package ru.job4j.StreamApi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Convert {
    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 3, 5},
                {2, 4, 6},
                {2, 5, 8}
        };

    List<Integer> convert = Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
        System.out.println(convert);
    }
}
