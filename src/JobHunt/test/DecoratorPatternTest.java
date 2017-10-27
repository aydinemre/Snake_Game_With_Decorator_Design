package JobHunt.test;

import JobHunt.Main.Game.Core.DecoratorPattern.Anaconda;
import JobHunt.Main.Game.Core.DecoratorPattern.ForeignLanguage;
import JobHunt.Main.Game.Core.DecoratorPattern.Internships;
import JobHunt.Main.Game.Core.DecoratorPattern.Snake;

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
