package JobHunt.Main.Game.Foods;

import JobHunt.Main.Game.Core.Point;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Optional;

public abstract class Food {

    private Color foodColor;

    private Image foodImage;

    private Point point;


    public Food(Point point) {
        this.point = point;
    }

    public Food(Point point, Optional<Image> image, Optional<Color> foodColor) {

        this.point      = point;
        this.foodImage  = image.orElse(null);
        this.foodColor  = foodColor.orElse(null);

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
