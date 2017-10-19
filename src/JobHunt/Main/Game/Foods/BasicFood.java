package JobHunt.Main.Game.Foods;

import JobHunt.Main.Game.Core.Point;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class BasicFood extends AbstractFood{


    public BasicFood(Point point) {
        super(point);
        setFoodColor(Color.LIGHTGOLDENRODYELLOW);
    }

}
