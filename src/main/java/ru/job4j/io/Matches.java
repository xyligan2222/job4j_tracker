package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        System.out.println("Игра СПИЧКИ");
        System.out.println("На столе лежат 11 спичек.");
        System.out.println("Два игрока по очереди берут от 1 до 3 спичек.");
        System.out.println("Выигрывает тот, кто забрал последние спички.");
        System.out.println("");
        int matches = 11;
        boolean run = true;
        Scanner input = new Scanner(System.in);
        int count = 0;
        int move = 0;
        String players;
        String player1 = " Игрок 1 ";
        String player2 = " Игрок 2 ";
        while (run) {
            if (count % 2 == 0){
                players = player1;
            } else {
                players = player2;
            }

            System.out.println("На столе " + matches + " спичек. Тяните спички." + players);
            move = Integer.valueOf(input.nextLine());
            if ((move > 3) || (move < 0)) {
                System.out.println("Вы можете взять только от 1 до 3 спичек.");
            }
            else if (move > matches) {
                System.out.println("На столе меньше спичек чем хотите взять");
            }  else if (move > 0 && move <= 3) {
                matches -= move;
                count++;
                if (matches == 0) {
                    System.out.println("Вы победили ");
                    run = false;
                }

            }

        }

    }
}
