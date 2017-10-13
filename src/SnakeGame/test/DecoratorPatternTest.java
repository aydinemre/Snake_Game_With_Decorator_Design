package SnakeGame.test;

import SnakeGame.Main.DecoratorPattern.Anaconda;
import SnakeGame.Main.DecoratorPattern.ForeignLanguage;
import SnakeGame.Main.DecoratorPattern.Internships;
import SnakeGame.Main.DecoratorPattern.Snake;

public class DecoratorPatternTest {
    public static void main(String[] args) {

        Snake snake = new Anaconda();
        System.out.println(snake);
        snake = new ForeignLanguage(snake);
        System.out.println(snake.getMultiplier());
        snake = new Internships(snake);
        System.out.println(snake.getMultiplier());
        snake = new Internships(snake);
        System.out.println(snake.getMultiplier());

    }
}
