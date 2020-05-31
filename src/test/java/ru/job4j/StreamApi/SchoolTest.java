package ru.job4j.StreamApi;


import org.junit.Test;
import ru.job4j.lambda.Attachment;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {

    @Test
    public void whenStudentsFrom70To100() {
        List<Student> input = List.of(
                new Student("Petrov", 50),
                new Student("Ivanov", 90),
                new Student("Shirokov", 95),
                new Student("Sidorov", 20)
                );
        School school = new School();
        List<Student> result = school.collect(input, n -> n.getScore() >= 70 && n.getScore() <= 100);
        List<Student> expected = Arrays.asList(
                new Student("Ivanov", 90),
                new Student("Shirokov", 95)

        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsFrom50To70() {
        List<Student> input = List.of(
                new Student("Petrov", 50),
                new Student("Ivanov", 90),
                new Student("Shirokov", 65),
                new Student("Sidorov", 20)
        );
        School school = new School();
        List<Student> result = school.collect(input, n -> n.getScore() >= 50 && n.getScore() < 70);
        Comparator<Student> lengthCmp = Comparator.comparing(Student::getSurname);
        result.sort(lengthCmp);
        List<Student> expected = Arrays.asList(
                new Student("Petrov", 50),
                new Student("Shirokov", 65)

        );
        assertThat(result, is(expected));
    }
    @Test
    public void whenStudentsFrom0To50() {
        List<Student> input = List.of(
                new Student("Petrov", 50),
                new Student("Ivanov", 30),
                new Student("1Shirokov", 65),
                new Student("Sidorov", 20)
        );
        School school = new School();
        List<Student> result = school.collect(input, n -> n.getScore() > 0 && n.getScore() < 50);
        Comparator<Student> lengthCmp = Comparator.comparing(Student::getSurname);
        result.sort(lengthCmp);
        List<Student> expected = Arrays.asList(
                new Student("Ivanov", 30),
                new Student("Sidorov", 20)

        );
        assertThat(result, is(expected));
    }


}