package JobHunt.Main.Game.DecoratorPattern;

import JobHunt.Main.Game.Core.Point;
import JobHunt.Main.R;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Anaconda extends Snake {

    public Anaconda() {

        // Assign color.
        color = Color.RED;

        // Assign description.
        description = "Snake Genera : Anaconda";

        // Assign snake square.
        snakeSquare = 2;

        points = new ArrayList<>();


        points.add(new Point(R.GAME_SCREEN_WIDTH / R.CELL_SCALE/ 2,
                R.GAME_SCREEN_HEIGHT / R.CELL_SCALE / 2));
    }

    @Override
    public double getMultiplier() {
        return 2;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }


}
