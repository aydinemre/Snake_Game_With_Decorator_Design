package JobHunt.Main.Game.Core.Foods.PowerUps;

import JobHunt.Main.Game.Core.Foods.AbstractFood;
import JobHunt.Main.Game.Core.Point;
import javafx.scene.paint.Color;

public abstract class PowerUp extends AbstractFood {

    public PowerUp(Point location, Color powerUpColor) {
        super(location);
    }
}
