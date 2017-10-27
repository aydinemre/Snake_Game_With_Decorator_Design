package JobHunt.Main.Game.Core.Foods;

import JobHunt.Main.Game.Core.Point;
import javafx.scene.paint.Color;

public class Food extends AbstractFood {
    public Food(Point point) {
        super(point);
        setFoodColor(Color.ROSYBROWN);
    }
}
