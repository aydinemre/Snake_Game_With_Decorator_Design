package JobHunt.resources.Screens;

import JobHunt.Main.R;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameWindow {

    private VBox rootVBox;
        private HBox canvasListViewHBox;
            private StackPane stackPane;
                private Canvas canvas;
            private ListView<String>listView;
                private ObservableList<String> itemList;
        private HBox stats;
            private Label scoreTable;
            private ProgressBar stamina;

    private Scene scene;



    public GameWindow(){

        // Create main component.
        rootVBox = new VBox();

        canvasListViewHBox = new HBox();
        stackPane   = new StackPane();
        listView    = new ListView<>();
        canvas      = new Canvas( R.GAME_SCREEN_WIDTH,   R.GAME_SCREEN_HEIGHT );
        stackPane.getChildren().add(canvas);

        itemList    = FXCollections.observableArrayList ("default");
        listView.setItems(itemList);

        listView.setFocusTraversable(false);
        listView.setOnKeyPressed(Event::consume);

        canvasListViewHBox.getChildren().addAll(stackPane,listView);

        stats       = new HBox();
        stats.setStyle("-fx-border-width: 1;" + "-fx-border-color: aquamarine;");

        // Create a label to print score and some information.
        scoreTable = new Label();
        scoreTable.setPrefWidth(227);
        // Progress bar for stamina.
        stamina = new ProgressBar(0);
        stamina.prefWidthProperty().bind(rootVBox.widthProperty().divide(3));

        // Add label and progress bar to stats component.
        stats.getChildren().addAll(scoreTable, stamina);
        stats.setFillHeight(true);

        // Set spacing and alignment.
        stats.setAlignment(Pos.CENTER);

        // Add components to rootVBox.
        rootVBox.getChildren().addAll(canvasListViewHBox,stats);

        // Create a new scene with rootVBox.
        scene   = new Scene(rootVBox);
    }

    public VBox getRootVBox() {
        return rootVBox;
    }

    public HBox getCanvasListViewHBox() {
        return canvasListViewHBox;
    }

    public StackPane getStackPane() {
        return stackPane;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public ListView<String> getListView() {
        return listView;
    }

    public ObservableList<String> getItemList() {
        return itemList;
    }

    public HBox getStats() {
        return stats;
    }

    public Label getScoreTable() {
        return scoreTable;
    }

    public ProgressBar getStamina() {
        return stamina;
    }

    public Scene getScene() {
        return scene;
    }
}
