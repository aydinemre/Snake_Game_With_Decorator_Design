package JobHunt.Main.Game.Core;

public enum SNAKE_TYPES {
    Python("Python",1,1),
    Anaconda("Anaconda",2,2);

    private String snakeName;
    private double multiplier;
    private int square;

    private SNAKE_TYPES(String snakeName, double multiplier, int square) {
        this.snakeName = snakeName;
        this.multiplier = multiplier;
        this.square = square;
    }

    public String getSnakeName() {
        return snakeName;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public int getSquare() {
        return square;
    }
}
