package JobHunt.Main.Game.Core;

import JobHunt.Main.Game.DecoratorPattern.Snake;
import JobHunt.Main.Game.Foods.BasicFood;
import JobHunt.Main.Game.Foods.Food;
import JobHunt.Main.R;
import JobHunt.resources.Painter;
import JobHunt.resources.Screens.GameWindow;
import javafx.animation.AnimationTimer;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;


public class Game extends AnimationTimer{

    // All screen components holds in gameWindows object.(E.g: Progress bar,Canvas ...)
    private GameWindow gameWindow;

    // Frame and Game speed.
    private long sleepNanoSecond;
    private long framePrevTime = 0;

    // Game core parts : Snake , Food and Progress Bar Controller.
    private Snake snake;
    private Food food;
    private ProgressBarController progressBarController;


    // Game stats.
    private int foodCounter = 0;
    private int score = 0;

    // Row number, col number.
    private int rowNumber;
    private int colNumber;

    // To pause game.
    private boolean pause;

    public Game(GameWindow gameWindow, long sleepMillisecond, Snake snake){

        this.gameWindow = gameWindow;

        this.gameWindow.getCanvas().setFocusTraversable(true);

        // Add keyboard controller.
        this.gameWindow.getCanvas().addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, key -> {
            if(key.getCode() == KeyCode.UP) { snake.changeDirection(Directions.UP);
            } else if (key.getCode() == KeyCode.DOWN) { snake.changeDirection(Directions.DOWN);
            } else if (key.getCode() == KeyCode.LEFT) { snake.changeDirection(Directions.LEFT);
            } else if (key.getCode() == KeyCode.RIGHT) { snake.changeDirection(Directions.RIGHT);
            } else if (key.getCode() == KeyCode.ENTER){ pause = !pause; }
        });

        // Game speed.
        this.sleepNanoSecond = sleepMillisecond * 1000000;
        this.snake = snake;

        // Calculate row number and col number.
        rowNumber = R.GAME_SCREEN_HEIGHT / R.CELL_SCALE;
        colNumber = R.GAME_SCREEN_WIDTH  / R.CELL_SCALE;

        // Create first random food.
        food = new BasicFood(Point.getRandomPoint(rowNumber,colNumber,snake.getPoints()));

        // Not pause
        pause = false;

        // Create a thread to control totalTime bar.
        progressBarController = new ProgressBarController(gameWindow.getStamina(),15);

    }

    // This function will call in each frame.
    @Override
    public void handle(long currentTime){

        // Check current timePeriod and
        if ( (currentTime - framePrevTime) < sleepNanoSecond || pause ) return;

        updateFrame();
        framePrevTime = currentTime;
        String status = "";

        // Check stamina.
        status += progressBarController.isFinish;

        if (!snake.getSnakeDirection().equals(Directions.START)) {

            // Update stamina.
            progressBarController.update();
            status += " " + gameWindow.getStamina().getProgress();
        }

        // Check is death.
        status += " " + snake.isSafe();


        // Check food counter.
        status += " " + foodCounter;

        // Point
        status += " " + score;
        gameWindow.getScoreTable().setText("Stat : " + status);

    }

    private void updateFrame() {

        // Clear canvas
        gameWindow.getCanvas().getGraphicsContext2D().clearRect(0,0,R.GAME_SCREEN_WIDTH,R.GAME_SCREEN_HEIGHT);

        // Check is snake eat food ?
        if (isSnakeEatFood(food)) {
            ++foodCounter;
            score += snake.getMultiplier();
            snake.extend(rowNumber,colNumber);
            food = new BasicFood(Point.getRandomPoint(rowNumber, colNumber, snake.getPoints()));
        }
        else
            snake.move(rowNumber,colNumber);

        Painter.paint(gameWindow.getCanvas().getGraphicsContext2D(),snake,food.getPoint());

        // Check is snake dead ?


    }


    private boolean isSnakeEatFood(Food food) {
        return food.getPoint().equals(snake.getCurrentPosition());
    }

    /**
     * Progress bar controller.
     */
    private class ProgressBarController {

        // Progress bar object.
        ProgressBar progressBar;

        double timePeriod;
        double currentTime;
        double totalTime;
        boolean isFinish = false;

        public ProgressBarController(ProgressBar progressBar, double totalTime) {

            this.progressBar = progressBar;

            this.timePeriod = 1.0 / totalTime;
            this.currentTime = totalTime;
            this.totalTime  = totalTime;

        }

        public void update() {
            if (!isFinish){
                progressBar.setProgress(currentTime / totalTime);
                currentTime -= timePeriod;
                if (currentTime < 0)
                    isFinish = true;
            }
        }

        public void showCurrentProgress(){
            progressBar.setProgress(currentTime / totalTime);
        }

        public void reset(){
            currentTime = totalTime;
        }
    }
}
