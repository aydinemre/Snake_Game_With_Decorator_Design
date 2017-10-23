package JobHunt.Main.Game.DecoratorPattern;

import JobHunt.Main.Game.Core.Point;

public class Internships extends SnakeDecorator{

    public Internships(Snake snake) {
        this.snake = snake;
    }
    public String getDesription() {
        return snake.getDescription() + " + Internship ";
    }

    @Override
    public double getMultiplier() {
        return 1.5 * snake.getMultiplier();
    }

}
