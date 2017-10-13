package SnakeGame.Main.DecoratorPattern;

public abstract class Snake {

    String description = "Unknown description";


    public String getDescription() {
        return description;
    }

    public abstract double getMultiplier();
//    public abstract int snakeSquare();

}
