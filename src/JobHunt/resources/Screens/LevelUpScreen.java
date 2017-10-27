package JobHunt.resources.Screens;

import JobHunt.Main.Game.Core.DecoratorPattern.*;
import JobHunt.Main.R;
import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LevelUpScreen {

    public static Snake modifySnake(Snake currentSnake) {

        // Get all snake types from R file.
        List<String> choices = new ArrayList<>();
        for(R.DECORATORS decorator_types: R.DECORATORS.values())
            choices.add(decorator_types.name());

        // Create choice dialog box
        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);

        dialog.setTitle("Choice  Type");
        dialog.setHeaderText("Look, a Choice Dialog");
        dialog.setContentText(" Types :");

        Optional<String> result = dialog.showAndWait();
        dialog.close();
        String resultString = result.get();
        if (R.DECORATORS.valueOf(resultString) == R.DECORATORS.Internship)
            return new Internships(currentSnake);
        else if (R.DECORATORS.valueOf(resultString) == R.DECORATORS.Training_Certificate)
            return new TrainingCertificates(currentSnake);
        else if (R.DECORATORS.valueOf(resultString) == R.DECORATORS.Foreign_Language)
            return new ForeignLanguage(currentSnake);
        return currentSnake;
    }
}
