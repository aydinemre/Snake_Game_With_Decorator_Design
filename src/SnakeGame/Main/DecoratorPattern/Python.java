package SnakeGame.Main.DecoratorPattern;

public class Python extends Snake{

    public Python() {
        description = "Snake Genera : Python";
    }

    @Override
    public double getMultiplier() {
        return 1;
    }

//    @Override
//    public int snakeSquare() {
//        return 1;
//    }
}
