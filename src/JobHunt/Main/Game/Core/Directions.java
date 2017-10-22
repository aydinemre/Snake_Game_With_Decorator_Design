package JobHunt.Main.Game.Core;

public enum Directions {
    UP      (0, -1),
    DOWN    (0,  1),
    LEFT    (-1, 0),
    RIGHT   ( 1, 0),
    START    ( 0, 0);

    private final int xVelocity;
    private final int yVelocity;

    private Directions(int xVelocity, int yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

}