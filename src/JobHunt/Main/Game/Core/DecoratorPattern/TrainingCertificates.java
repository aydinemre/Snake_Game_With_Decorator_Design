package JobHunt.Main.Game.Core.DecoratorPattern;

public class TrainingCertificates extends SnakeDecorator{

    public TrainingCertificates(Snake snake) {
        this.snake = snake;
    }

    public String getDesription() {
        return snake.getDescription() + " + Training Certificates ";
    }

    @Override
    public double getMultiplier() {
        return 3 * snake.getMultiplier();
    }

}
