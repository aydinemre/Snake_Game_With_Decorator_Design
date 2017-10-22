package JobHunt.Main.Game.DecoratorPattern;

import JobHunt.Main.Game.Core.Point;
import JobHunt.Main.R;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Python extends Snake{

    public Python() {

        color = Color.GREEN;

        description = "Main Genera : Python";

        points = new ArrayList<>();

        points.add(new Point(R.GAME_SCREEN_WIDTH / R.CELL_SCALE / 2,
                R.GAME_SCREEN_HEIGHT / R.CELL_SCALE /2));

        snakeSquare = 1;

    }

    @Override
    public double getMultiplier() {
        return 1;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }
}
