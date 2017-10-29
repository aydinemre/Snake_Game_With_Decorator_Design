package JobHunt.Main.Game.Core.Foods.PowerUps;

import JobHunt.Main.Game.Core.Foods.AbstractFood;
import JobHunt.Main.Game.Core.Point;
import javafx.scene.image.Image;

import java.io.File;

public abstract class PowerUp extends AbstractFood {

    protected String basePath = ".." + File.separator +
            ".." + File.separator +
            ".." + File.separator +
            ".." + File.separator +
            ".." + File.separator +
            "resources" + File.separator +
            "Images" + File.separator;
    public PowerUp(Point location) {
        super(location);
        this.foodColor = null;
    }
}
