package JobHunt.Main.Game.Core.Foods.Companies;

import JobHunt.Main.Game.Core.Foods.AbstractFood;
import JobHunt.Main.Game.Core.Point;
import javafx.scene.paint.Color;


public class CompanyFood extends AbstractFood{

    public CompanyFood(Point point, Color companyColor) {
        super(point);
        setFoodColor(companyColor);
    }

}
