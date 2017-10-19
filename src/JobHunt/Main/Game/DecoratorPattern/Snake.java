package JobHunt.Main.Game.DecoratorPattern;


import JobHunt.Main.Game.Core.Point;
import JobHunt.Main.Game.Foods.PowerUps.PowerUp;
import javafx.scene.paint.Color;

import java.util.List;

public abstract class Snake {

    protected Color color = Color.WHITE;

    private PowerUp powerUp;

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    // Description for each extended Main class.
    protected String description = "Unknown description";

    public String getDescription() {
        return description;
    }

    // Each snake must have square.
    // E.g: Anaconda is 2n ,Python is n
    protected int snakeSquare;

    public int getSnakeSquare() {
        return snakeSquare;
    }

    @Override
    public String toString() {
        return "Snake{" +
                " description='" + description +
                ", color=" + color +
                ", snakeSquare=" + snakeSquare +
                '}';
    }

    protected List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    protected Point currentPosition;

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public abstract double getMultiplier();

}
