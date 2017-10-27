package JobHunt.Main.Game.Core.Foods;

import JobHunt.Main.Game.Core.Point;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public abstract class AbstractFood {

    private Color foodColor = Color.ROSYBROWN;
    private Image foodImage;
    private Point point;


    public AbstractFood(Point point) {
        this.point = point;
    }

    public Color getFoodColor() {
        return foodColor;
    }

    public void setFoodColor(Color foodColor) {
        this.foodColor = foodColor;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Image getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(Image foodImage) {
        this.foodImage = foodImage;
    }
}
