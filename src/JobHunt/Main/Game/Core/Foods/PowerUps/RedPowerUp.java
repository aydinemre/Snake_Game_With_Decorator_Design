package JobHunt.Main.Game.Core.Foods.PowerUps;

import JobHunt.Main.Game.Core.Point;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class RedPowerUp extends PowerUp {

    public RedPowerUp(Point point) {
        super(point);
        Image image = new Image(getClass().getResource(basePath + "RedPowerUp.png").toExternalForm());
        this.setFoodImage(image);
    }
}
