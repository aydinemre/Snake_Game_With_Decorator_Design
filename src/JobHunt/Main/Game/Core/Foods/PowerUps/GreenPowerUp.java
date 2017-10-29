package JobHunt.Main.Game.Core.Foods.PowerUps;

import JobHunt.Main.Game.Core.Point;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.File;

public class GreenPowerUp extends PowerUp {

    public GreenPowerUp(Point point) {
        super(point);
        Image image = new Image(getClass().getResource(basePath + "GreenPowerUp.png").toExternalForm());

        this.setFoodImage(image);

    }
}
