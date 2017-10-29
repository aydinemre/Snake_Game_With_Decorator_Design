package JobHunt.resources;

import JobHunt.Main.Game.Core.Foods.AbstractFood;
import JobHunt.Main.Game.Core.Point;
import JobHunt.Main.Game.Core.DecoratorPattern.Snake;
import JobHunt.Main.R;
import JobHunt.resources.Screens.GameWindow;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.List;

public class Painter {

    public static void paint(GameWindow gameWindow, Snake snake, List<AbstractFood> foodList) {

        GraphicsContext graphicsContext2D = gameWindow.getCanvas().getGraphicsContext2D();

        for (AbstractFood food:foodList) {
            if (food != null) {
                if (food.getFoodColor() == null){
                    Image image = food.getFoodImage();
                    graphicsContext2D.drawImage(image,food.getPoint().getX(),food.getPoint().getY());

                }else {
                    graphicsContext2D.setFill(food.getFoodColor());
                    graphicsContext2D.fillRect(food.getPoint().getX() * R.CELL_SCALE,
                            food.getPoint().getY() * R.CELL_SCALE,
                            R.CELL_SCALE,
                            R.CELL_SCALE);
                }
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

    public static void showGameOver(GraphicsContext graphicsContext2D) {

        graphicsContext2D.setFill(new Color(0.49803922f, 1.0f, 0.83137256f,0.1));
        graphicsContext2D.fillRect(0,0,R.GAME_SCREEN_WIDTH,R.GAME_SCREEN_HEIGHT);

        graphicsContext2D.setFill(Color.BLACK);
        graphicsContext2D.fillText("Hit Enter to reset",R.GAME_SCREEN_WIDTH/2 - 10,R.GAME_SCREEN_HEIGHT/3);
    }

}
