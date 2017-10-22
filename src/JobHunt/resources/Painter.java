package JobHunt.resources;

import JobHunt.Main.Game.Core.Point;
import JobHunt.Main.Game.DecoratorPattern.Snake;
import JobHunt.Main.R;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Painter {


    public static void paint(GraphicsContext graphicsContext2D, Snake snake, Point foodPoint) {
//        graphicsContext2D.setFill(new Color(0.1, 0.1, 0.1, 1));
//        graphicsContext2D.fillRect(0,0,graphicsContext2D.getCanvas().getWidth(),graphicsContext2D.getCanvas().getHeight());

        graphicsContext2D.setFill(Color.ROSYBROWN);
        graphicsContext2D.fillRect(foodPoint.getX() * R.CELL_SCALE, foodPoint.getY() * R.CELL_SCALE, R.CELL_SCALE, R.CELL_SCALE);

        graphicsContext2D.setFill(snake.getColor());
        snake.getPoints().forEach(point -> paintPoint(point, graphicsContext2D));
        if (!snake.isSafe()) {
            graphicsContext2D.setFill(Color.RED);
            paintPoint(snake.getCurrentPosition(), graphicsContext2D);
        }
    }

    private static void paintPoint(Point point, GraphicsContext gc) {
        gc.fillRect(point.getX() * R.CELL_SCALE, point.getY() * R.CELL_SCALE, R.CELL_SCALE, R.CELL_SCALE);
    }
}
