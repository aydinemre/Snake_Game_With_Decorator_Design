package JobHunt.resources;

import JobHunt.Main.Game.Core.Foods.AbstractFood;
import JobHunt.Main.Game.Core.Point;
import JobHunt.Main.Game.Core.DecoratorPattern.Snake;
import JobHunt.Main.R;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Painter {


    public static void paint(GraphicsContext graphicsContext2D, Snake snake, List<AbstractFood> foodList) {

        for (AbstractFood food:foodList) {
            if (food != null) {
                graphicsContext2D.setFill(food.getFoodColor());
                graphicsContext2D.fillRect(food.getPoint().getX() * R.CELL_SCALE,
                        food.getPoint().getY() * R.CELL_SCALE,
                        R.CELL_SCALE,
                        R.CELL_SCALE);
            }
        }

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
