package JobHunt.Main.Game.DecoratorPattern;

import JobHunt.Main.Game.Core.Directions;
import JobHunt.Main.Game.Core.Point;
import JobHunt.Main.Game.Foods.PowerUps.PowerUp;
import javafx.scene.paint.Color;

import java.util.List;

public abstract class SnakeDecorator extends Snake {

    Snake snake;

    @Override
    public String getDescription() {
        return snake.getDescription();
    }

    @Override
    public Color getColor() {
        return snake.getColor();
    }

    @Override
    public PowerUp getPowerUp() {
        return snake.getPowerUp();
    }

    @Override
    public void setPowerUp(PowerUp powerUp) {
        snake.setPowerUp(powerUp);
    }

    @Override
    public Directions getSnakeDirection() {
        return snake.getSnakeDirection();
    }

    @Override
    public void setSnakeDirection(Directions snakeDirection) {
        snake.setSnakeDirection(snakeDirection);
    }

    @Override
    public int getSnakeSquare() {
        return snake.getSnakeSquare();
    }

    @Override
    public List<Point> getPoints() {
        return snake.getPoints();
    }

    @Override
    public Point getCurrentPosition() {
        return snake.getCurrentPosition();
    }

    @Override
    public void move(int rowNumber, int colNumber) {
        snake.move(rowNumber, colNumber);
    }

    @Override
    public void changeDirection(Directions directions) {
        snake.changeDirection(directions);
    }

    @Override
    public boolean isSafe() {
        return snake.isSafe();
    }

    @Override
    public void setSafe(boolean safe) {
        snake.setSafe(safe);
    }

    @Override
    public void extend(int rowNumber, int colNumber) {
        snake.extend(rowNumber, colNumber);
    }

    @Override
    public String toString() {
        return snake.toString();
    }
}
