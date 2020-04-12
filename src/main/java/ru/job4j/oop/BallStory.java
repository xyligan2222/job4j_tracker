package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Hare hare = new Hare();
        Ball ball = new Ball();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();

        hare.tryEat(ball);
        fox.tryEat(ball);
        wolf.tryEat(ball);
    }
}
