package JobHunt.Main.Game.DecoratorPattern;

import JobHunt.Main.Game.Core.Point;
import JobHunt.Main.R;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Python extends Snake{

    public Python() {

        color = Color.LIGHTGOLDENRODYELLOW;

        description = "Main Genera : Python";

        snakeSquare = 1;

        points = new ArrayList<>();

        currentPosition = new Point(R.GAME_SCREEN_WIDTH / 2,R.GAME_SCREEN_HEIGHT / 2);

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
