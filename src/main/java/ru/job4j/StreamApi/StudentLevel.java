package ru.job4j.StreamApi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {

    public static List<Student> levelOf(List<Student> students, int bound) {
            return   students.stream()
                    .flatMap(Stream::ofNullable)
                    .sorted(Comparator.comparing(Student::getSurname))
                    .dropWhile(st -> st.getScore() < bound)
                    .collect(Collectors.toList());

    }
}