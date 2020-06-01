package ru.job4j.StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Petrov", 50),
                new Student("Ivanov", 90),
                new Student("Shirokova", 45),
                new Student("Sykova", 65),
                new Student("Voron", 55),
                new Student("Sharik", 35),
                new Student("Sidorov", 20)
        );
        Map<String, Student> rsl = students.stream().distinct().collect(Collectors.toMap(e -> e.getSurname(), e -> e));

        for (Map.Entry<String, Student> entry : rsl.entrySet()) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println("surname " + key + ",  " + value);
        }
    }
}
