package JobHunt.resources.Screens;

import JobHunt.Main.R;
import javafx.animation.AnimationTimer;
import javafx.scene.control.ChoiceDialog;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WelcomeWindow implements Runnable {

    public static String returnValue;

    //    http://code.makery.ch/blog/javafx-dialogs-official/
    // TODO :: Add animation for each snake.
    // TODO :: Add icon for dialog box.
    public static String getSnakeType() {


        // Get all snake types from R file.
        List<String> choices = new ArrayList<>();
        for(R.SNAKE_TYPES snake_types: R.SNAKE_TYPES.values())
            choices.add(snake_types.name());

        // Create choice dialog box
        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);

        dialog.setTitle("Choice Snake Type");
        dialog.setHeaderText("Look, a Choice Dialog");
        dialog.setContentText("Snake Types :");

        Optional<String> result = dialog.showAndWait();
        dialog.close();
        returnValue = result.get();
        return returnValue;

    }

    public static String getReturnValue() {
        return returnValue;
    }

    @Override
    public void run() {
        getSnakeType();
    }
}
