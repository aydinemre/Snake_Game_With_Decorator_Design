package JobHunt.Main.Game.Core;

import JobHunt.Main.Game.DecoratorPattern.Snake;
import JobHunt.Main.R;
import javafx.scene.paint.Color;

public class Game {

    private Color gamePanelColor = new Color(0.1,0.1,0.1,1);

    private int rowNumber;
    private int colNumber;

    private Snake gameSnake;
    private Point apple;

    public Game(int width, int height,Snake snake){

        colNumber = width  / R.ONE_COL_SIZE;
        rowNumber = height / R.ONE_ROW_SIZE;

        gameSnake = snake;

        apple = Point.getRandomPoint(rowNumber,
                colNumber,
                gameSnake.getPoints());


    }

    public Snake getGameSnake() {
        return gameSnake;
    }

}
