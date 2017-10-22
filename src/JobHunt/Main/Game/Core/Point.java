package JobHunt.Main.Game.Core;

import java.util.List;
import java.util.Random;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return x == point.x && y == point.y;
    }
    public Point translate(int dx, int dy) {
        return new Point(x + dx, y + dy);
    }
    public static Point getRandomPoint(int rowSize, int colonSize, List<Point>snakePoints) {

        Random random = new Random();
        Point point;

        do {
            point = new Point(random.nextInt(rowSize), random.nextInt(colonSize));
        } while (snakePoints.contains(point));

        return point;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
