package JobHunt.Main.Game.Core.DecoratorPattern;


import JobHunt.Main.Game.Core.Directions;
import JobHunt.Main.Game.Core.Foods.Companies.CompanyFood;
import JobHunt.Main.Game.Core.Point;
import JobHunt.Main.Game.Core.Foods.PowerUps.PowerUp;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class Snake {

    protected String description = "Unknown description";
    protected Color color;
    private PowerUp powerUp;
    private Directions snakeDirection = Directions.START;
    protected int snakeSquare;
    private boolean safe = true;
    protected List<CompanyFood> cv;

    // Getter for description.
    public String getDescription() { return description; }

    // Getter for color.
    public Color getColor() { return color; }

    // In my implementation i used strategy pattern for power ups.
    public PowerUp getPowerUp() {
        return powerUp;
    }
    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    // Getter && Setter for snake direction.
    public Directions getSnakeDirection() {
        return snakeDirection;
    }
    public void setSnakeDirection(Directions snakeDirection) {
        this.snakeDirection = snakeDirection;
    }

    // Getter for snake square
    public int getSnakeSquare() {
        return snakeSquare;
    }

    // List of snake points.
    protected List<Point> points = new ArrayList<>();
    ;
    public List<Point> getPoints() {
        return points;
    }

    // Head of snake.
    public Point getCurrentPosition() {
        return points.get(points.size()-1);
    }

    /** Decorator pattern common method. Each class will implement this method. **/
    public abstract double getMultiplier();

    // Snake move function.
    public void move(int rowNumber, int colNumber){
        if (!(snakeDirection.equals(Directions.START))) {
            Point translatedPoint = getCurrentPosition().translate(snakeDirection.getxVelocity(),snakeDirection.getyVelocity());
            translatedPoint = checkNewPosition(rowNumber,colNumber,translatedPoint);
            safe = safe && !points.contains(translatedPoint);
            points.add(translatedPoint);
            points.remove(0);
        }

    }

    public void changeDirection(Directions directions){

        switch (directions){
            case UP:{
                if (snakeDirection.getyVelocity() == 1 && getPoints().size() > 1)
                    return;
                break;
            }
            case DOWN:{
                if (snakeDirection.getyVelocity() == -1 && getPoints().size() > 1)
                    return;
                break;
            }
            case LEFT:{
                if (snakeDirection.getxVelocity() == 1 && getPoints().size() > 1)
                    return;
                break;
            }
            case RIGHT:{
                if (snakeDirection.getxVelocity() == -1 && getPoints().size() > 1)
                    return;
                break;
            }
        }
        this.snakeDirection = directions;
    }


    public boolean isSafe() {
        return safe;
    }


    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public void extend(int rowNumber, int colNumber) {

        if (!(snakeDirection.equals(Directions.START))){
            Point translatedPoint = getCurrentPosition().translate(snakeDirection.getxVelocity(),snakeDirection.getyVelocity());
            translatedPoint = checkNewPosition(rowNumber,colNumber,translatedPoint);
            safe = safe && !points.contains(translatedPoint);
            points.add(translatedPoint);
        }
    }

    private Point checkNewPosition(int rowNumber, int colNumber, Point translatedPosition) {

        int x = translatedPosition.getX();
        int y = translatedPosition.getY();
        if (x >= rowNumber) x = 0;
        if (y >= colNumber) y = 0;
        if (x < 0) x = rowNumber - 1;
        if (y < 0) y = colNumber - 1;
        return new Point(x, y);
    }

    public List<CompanyFood> getCV(){ return cv; }

    public void addCompanyToCV(CompanyFood companyFood){
        cv.add(companyFood);
    }

    @Override
    public String toString() {
        return "Snake{" +
                "color=" + color +
                ", powerUp=" + powerUp +
                ", snakeDirection=" + snakeDirection +
                ", description='" + description + '\'' +
                ", snakeSquare=" + snakeSquare +
                ", points=" + points +
                ", safe=" + safe +
                '}';
    }

}
