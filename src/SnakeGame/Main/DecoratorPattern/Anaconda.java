package SnakeGame.Main.DecoratorPattern;

public class Anaconda extends Snake {

    public Anaconda() {
        description = "Snake Genera : Anaconda";
    }

    @Override
    public double getMultiplier() {
        return 2;
    }
//
//    @Override
//    public int snakeSquare() {
//        return 2;
//    }
}
