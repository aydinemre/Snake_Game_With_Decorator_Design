package JobHunt.test;

import JobHunt.Main.Game.DecoratorPattern.Anaconda;
import JobHunt.Main.Game.DecoratorPattern.ForeignLanguage;
import JobHunt.Main.Game.DecoratorPattern.Internships;
import JobHunt.Main.Game.DecoratorPattern.Snake;

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
