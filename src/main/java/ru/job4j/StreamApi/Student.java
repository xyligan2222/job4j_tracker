package ru.job4j.StreamApi;

import java.util.Objects;

public class Student {
    private int score;
    private String surname;

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }


    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int compareTo(Object o) {
        Student student = (Student) o;
        return Integer.compare(this.score, student.getScore());
    }


}
