package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        if (answer == 0){
            System.out.println("Да");
        }
        else if (answer == 1){
            System.out.println("Нет");
        }
        else if (answer > 1){
            System.out.println("Может быть");
        }
    }
}
