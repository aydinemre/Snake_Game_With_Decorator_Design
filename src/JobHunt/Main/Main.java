package JobHunt.Main;

import JobHunt.Main.Game.DecoratorPattern.Snake;
import JobHunt.resources.SnakeForest;
import JobHunt.resources.Screens.*;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Get snake type from user.
        String snakeType = WelcomeWindow.getSnakeType();

        // Oh! Catch a snake from snake forest
        Snake snake = SnakeForest.catchSnake(snakeType);

        // Set screen title.
        primaryStage.setTitle("Job Hunter");

        // Set not resizable :(
        // TODO: Make responsive??!?!?!?!!?!?
        primaryStage.setResizable(false);

        // Create game window.
        GameWindow gameWindow = new GameWindow();

        // Start Game.
        primaryStage.setScene(gameWindow.getScene());

        primaryStage.show();
    }
}
