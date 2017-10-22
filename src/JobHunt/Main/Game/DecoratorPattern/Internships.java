package JobHunt.Main.Game.DecoratorPattern;

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
