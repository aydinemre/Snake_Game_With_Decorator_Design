package JobHunt.Main;

import JobHunt.Main.Game.Core.DecoratorPattern.Snake;
import JobHunt.Main.Game.Core.Game;
import JobHunt.resources.Screens.GameWindow;
import JobHunt.resources.Screens.WelcomeScreen.WelcomeWindow;

import JobHunt.resources.SnakeForest;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create welcome screen and get snake type.
        new WelcomeWindow().getSnakeType();

        String snakeType = MyChangeListener.getValue();

        // Oh! Catch a snake from snake forest
        Snake snake = SnakeForest.catchSnake(snakeType);

        // Set screen title.
        primaryStage.setTitle("Job Hunter");

        // Set not resizable :( TODO:: Make responsive ne gerek var
        primaryStage.setResizable(false);

        // Add icon to program.
        primaryStage.getIcons().add(new Image(getClass().getResource(R.iconPath).toExternalForm()));

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
