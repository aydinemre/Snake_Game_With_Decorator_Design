package JobHunt.resources.Screens;

import JobHunt.Main.R;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameWindow {


    private VBox root;
    private HBox stats;
    private Canvas canvas;
    private Scene scene;
    private ProgressBar stamina;
    private Label scoreTable;


    public GameWindow(){

        // Create main component.
        root        = new VBox();
        stats       = new HBox();
        canvas      = new Canvas( R.GAME_SCREEN_WIDTH,   R.GAME_SCREEN_HEIGHT );

        // Add components to root.
        root.getChildren().addAll(canvas,stats);

        // Create a new scene with root.
        scene   = new Scene(root);

        // Create a label to print score and some information.
        scoreTable = new Label();

        // Progress bar for stamina.
        stamina = new ProgressBar(0);
        stamina.prefWidthProperty().bind(root.widthProperty().divide(3));

        // Add label and progress bar to stats component.
        stats.getChildren().addAll(scoreTable, stamina);

        // Set spacing and alignment.
//        stats.setSpacing(150);
        stats.setAlignment(Pos.CENTER);

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Scene getScene() {
        return scene;
    }

    public ProgressBar getStamina() {
        return stamina;
    }

    public Label getScoreTable() {
        return scoreTable;
    }
}
