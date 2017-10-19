package JobHunt.Main.Game.DecoratorPattern;

public class ForeignLanguage extends SnakeDecorator {

    public ForeignLanguage(Snake snake) {
        this.snake = snake;
    }

    @Override
    public String getDesription() {
        return snake.getDescription() + " + Foreign language learned";
    }

    @Override
    public double getMultiplier() {
        return 2 * snake.getMultiplier();
    }

}
