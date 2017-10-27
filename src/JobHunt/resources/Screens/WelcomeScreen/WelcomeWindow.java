package JobHunt.resources.Screens.WelcomeScreen;

import JobHunt.Main.Game.Core.SNAKE_TYPES;
import JobHunt.Main.MyChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class shows welcome screen and created to choose a character to play game.
 *
 * In this screen, the user is asked to select a character.
 *
 * In game, user has two option for characters.
 * First option
 *  - Python    : Pythons have x1 multiplier. And also its square x1
 * Second option
 *  - Anaconda : Anacondas have x2 multiplier. And also its square x2:
 *
 * This screen shows information of characters and a it's image to user.
 *
 *
 */
public class WelcomeWindow implements Initializable{

    // Tab pane holds tabs. And each tab includes information of a character
    @FXML private TabPane tabPane;

    // Tab change listener also holds last value as string.
    private MyChangeListener myChangeListener = MyChangeListener.getInstance();


    // Custom alert used
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);


    // Initialize method inject @FXML objects.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create tab for each snake type.
        tabPane.getTabs().clear();
        for(SNAKE_TYPES snake_types: SNAKE_TYPES.values()){
            Tab temp = createTab(snake_types.name());
            tabPane.getTabs().add(temp);
        }

        // Set change listener.
        tabPane.getSelectionModel().selectedItemProperty().addListener(myChangeListener);
    }

    // Helper method to create tab.
    private Tab createTab(String name) {

        // Create a tab.
        Tab newTab = new Tab(name);

        // Anchor pane to hold image, texts ...
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(180.0);
        anchorPane.setMinWidth(200.0);

        // Create image view to show image.
        ImageView imageView = new ImageView();
        String imagePath = name + ".png";
        Image image = new Image(getClass().getResource(imagePath).toExternalForm());
        imageView.setImage(image);
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(200.0);
        imageView.setLayoutY(32.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        // Snake name text.
        Text snakeNameText = new Text();
        snakeNameText.setText(name);
        snakeNameText.setLayoutX(160.0);
        snakeNameText.setLayoutY(234.0);
        snakeNameText.setStrokeType(StrokeType.OUTSIDE);
        snakeNameText.setStrokeWidth(0.0);
        snakeNameText.setTextAlignment(TextAlignment.CENTER);
        snakeNameText.setWrappingWidth(280.458984375);
        snakeNameText.setFont(Font.font(26.0));

        // Description.
        Text descriptionText = new Text();
        for(SNAKE_TYPES type:SNAKE_TYPES.values())
            if (type.getSnakeName().equals(name)) {
                descriptionText.setText("x"+ type.getMultiplier() + " Multiplier\t" +
                        "x" + type.getSquare() + " Square");

                break;
        }

        descriptionText.setLayoutX(202.0);
        descriptionText.setLayoutY(252.0);
        descriptionText.setStrokeType(StrokeType.OUTSIDE);
        descriptionText.setStrokeWidth(0.0);
        descriptionText.setWrappingWidth(176.7294921875);
        descriptionText.setTextAlignment(TextAlignment.CENTER);

        // Add all components to anchor pane.
        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(snakeNameText);
        anchorPane.getChildren().add(descriptionText);

        // Set anchor pane parent.
        newTab.setContent(anchorPane);

        // Return new tab.
        return newTab;
    }

    /**
     *
     * This method shows an alert and takes
     * input from user and returns input
     * snake name as string.
     * @return Snake name.
     */
    public void getSnakeType() {

        // Load custom alert from fxml file.
        BorderPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("WelcomeWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get alert dialog pane to modify.
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setHeader(root);
        // Add icon to application.
        String iconPath =  ".." + File.separator +".." + File.separator + "Images" + File.separator + "GameIcon.jpg";
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(getClass().getResource(iconPath).toExternalForm()));

        // Clear alert buttons.
        alert.getButtonTypes().clear();

        // Add my button.
        alert.getButtonTypes().add(new ButtonType("Start Your Career!"));

        // Show alert and wait input from user.
        alert.showAndWait();

    }


}
