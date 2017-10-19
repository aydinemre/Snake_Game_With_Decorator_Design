package JobHunt.resources.Screens;

import JobHunt.Main.R;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

public class GameWindow {

    // Main scene.
    private Scene scene;

    private Canvas canvas;

    private StackPane stackPane;


    public GameWindow(){

        canvas      = new Canvas(R.GAME_SCREEN_WIDTH,R.GAME_SCREEN_HEIGHT);
        stackPane   = new StackPane();
        stackPane.getChildren().addAll(canvas);
        scene       = new Scene(stackPane,stackPane.getWidth(),stackPane.getHeight());

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public StackPane getStackPane() {
        return stackPane;
    }

    public void setStackPane(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}
