package JobHunt.Main;

import JobHunt.Main.Game.Core.DecoratorPattern.Snake;
import JobHunt.Main.Game.Core.Game;
import JobHunt.resources.Screens.GameWindow;
import JobHunt.resources.Screens.WelcomeScreen.WelcomeWindow;

import JobHunt.resources.SnakeForest;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        WelcomeWindow welcomeWindow = new WelcomeWindow();

        // Get snake type from user.
        String snakeType = welcomeWindow.getSnakeType();

        // Oh! Catch a snake from snake forest
        Snake snake = SnakeForest.catchSnake(snakeType);

        // Set screen title.
        primaryStage.setTitle("Job Hunter");

        // Set not resizable :( TODO:: Make responsive ne gerek var
        primaryStage.setResizable(false);

        // Create game window.
        GameWindow gameWindow = new GameWindow();

        // Create game.
        Game game = new Game(gameWindow,R.GAME_START_SPEED,snake);
        game.start();


        // Start Game.
        primaryStage.setScene(gameWindow.getScene());

        primaryStage.show();

    }
}
