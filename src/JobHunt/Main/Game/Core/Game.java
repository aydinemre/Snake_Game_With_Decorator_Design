package JobHunt.Main.Game.Core;

import JobHunt.Main.Game.Core.DecoratorPattern.*;
import JobHunt.Main.Game.Core.Foods.AbstractFood;
import JobHunt.Main.Game.Core.Foods.Companies.CompanyFood;
import JobHunt.Main.Game.Core.Foods.Food;
import JobHunt.Main.Game.Core.Foods.PowerUps.GreenPowerUp;
import JobHunt.Main.Game.Core.Foods.PowerUps.PowerUp;
import JobHunt.Main.Game.Core.Foods.PowerUps.RedPowerUp;
import JobHunt.Main.R;
import JobHunt.resources.Companies;
import JobHunt.resources.Painter;
import JobHunt.resources.Screens.GameWindow;
import JobHunt.resources.Screens.LevelUpScreen;
import JobHunt.resources.SnakeForest;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;


public class Game extends AnimationTimer{


    // All screen components holds in gameWindows object.(E.g: Progress bar,Canvas ...)
    private GameWindow gameWindow;

    // Row number, col number.
    private int rowNumber;
    private int colNumber;

    // Frame and Game speed.
    private long speedInitialMiliSecond;
    private long speedNanoSecond;
    private long framePrevTime = 0;

    // Game core parts : Snake , Food and Progress Bar Controller.
    private Snake snake;
    private String snakeType;

    // Define all food types.
    private Food food;

    private CompanyFood companyFood;
    private RandomTimer companyFoodRandomTimer;

    private PowerUp powerUp;
    private RandomTimer powerUpRandomTimer;

    private ProgressBarController progressBarController;


    // Game stats.
    private int foodCounter = 0;
    private int bank = 0;
    private int currentSalary = 0;
    // Game level
    int gameLevel = 0;


    // To pause game.
    private AtomicBoolean pause;

    // Time lines.
    private Timeline companyFoodTimeLine;
    private Timeline powerUpTimeLine;

    /**
     * Game constructor.
     *
     * Takes a game window, a second for snake speed and snake as parameter.
     * And assign keyboard controller for game.
     * @param gameWindow game window
     * @param sleepMillisecond snake speed.
     * @param snake snake.
     */
    public Game(GameWindow gameWindow, long sleepMillisecond, Snake snake){

        // Take game window.
        this.gameWindow = gameWindow;

        // Add keyboard controller.
        this.gameWindow.getCanvas().setFocusTraversable(true);
        this.gameWindow.getCanvas().addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, key -> {
            if(key.getCode() == KeyCode.UP) { this.snake.changeDirection(Directions.UP);
            } else if (key.getCode() == KeyCode.DOWN) { this.snake.changeDirection(Directions.DOWN);
            } else if (key.getCode() == KeyCode.LEFT) { this.snake.changeDirection(Directions.LEFT);
            } else if (key.getCode() == KeyCode.RIGHT) { this.snake.changeDirection(Directions.RIGHT);
            } else if (key.getCode() == KeyCode.P) { pause.set(!pause.get());
            } else if (key.getCode() == KeyCode.ENTER && pause.get()) { reset();}

        });

        // Game speed.
        this.speedNanoSecond = sleepMillisecond * 1000000;
        this.speedInitialMiliSecond = sleepMillisecond;

        this.snake = snake;
        this.snakeType = snake.getDescription();

        this.snake.setPowerUp(null);

        // Calculate row number and col number.
        rowNumber = R.GAME_SCREEN_HEIGHT / R.CELL_SCALE;
        colNumber = R.GAME_SCREEN_WIDTH  / R.CELL_SCALE;

        // Create first random food.
        food = new Food(Point.getRandomPoint(rowNumber,colNumber,snake.getPoints()));

        // Not pause
        pause = new AtomicBoolean(false);

        // Create a control for stamina bar.
        progressBarController = new ProgressBarController(gameWindow.getStamina(),15);

        // Company foods random timers. // TODO : Code reeuse :/
        companyFoodRandomTimer = new RandomTimer(5,8,13,16);
        companyFoodRandomTimer.isAvailable.set(true);

        // Start companyFoodTimeLine
        companyFoodTimeLine = new Timeline(new KeyFrame(Duration.seconds(1), event -> {}));
        // In each 1 cyle set on finished method will run.
        companyFoodTimeLine.setCycleCount(1);
        // companyFoodTimeLine set on finished method.
        companyFoodTimeLine.setOnFinished(event -> {
            companyFoodRandomTimer.switchIsAvailable();
            companyFood = new CompanyFood(Point.getRandomPoint(rowNumber,colNumber,snake.getPoints()), Companies.GOOGLE.getColor());
            companyFoodTimeLine.getKeyFrames().set(0,new KeyFrame(Duration.seconds(companyFoodRandomTimer.getRandomTime()), event1 -> System.out.println("deva")));
            companyFoodTimeLine.play();
        });

        // TODO :: Code reuse
        powerUpRandomTimer = new RandomTimer(3,5,15,20);
        powerUpRandomTimer.isAvailable.set(true);

        // Start powerUpTimeLine
        powerUpTimeLine = new Timeline(new KeyFrame(Duration.seconds(1), event -> {}));
        // In each 1 cyle set on finished method will run.
        powerUpTimeLine.setCycleCount(1);
        // powerUpTimeLine set on finished method.
        powerUpTimeLine.setOnFinished(event -> {
            powerUpRandomTimer.switchIsAvailable();

            List<Point>pointList = new ArrayList<>();
            pointList.addAll(snake.getPoints());
            if (food != null)
                pointList.add(food.getPoint());

            if ( powerUpRandomTimer.getRandomTimeSecure() % 2 == 0 ){
                powerUp = new GreenPowerUp(Point.getRandomPoint(rowNumber,colNumber,pointList));
            }else
                powerUp = new RedPowerUp(Point.getRandomPoint(rowNumber,colNumber,pointList));

            powerUpTimeLine.getKeyFrames().set(0,new KeyFrame(Duration.seconds(powerUpRandomTimer.getRandomTime()), event1 -> System.out.println("hello")));
            powerUpTimeLine.play();
        });

        companyFoodTimeLine.play();
        powerUpTimeLine.play();
    }

    private void reset() {

        // Reset all things.
        this.speedNanoSecond = speedInitialMiliSecond * 1000000;
        this.snake = SnakeForest.catchSnake(snakeType);
        this.snake.setPowerUp(null);
        this.framePrevTime = 0;
        this.snake.setSnakeDirection(Directions.START);

        this.foodCounter = 0;
        this.bank = 0;
        this.gameLevel = 0;

        food = new Food(Point.getRandomPoint(rowNumber,colNumber,snake.getPoints()));
        this.companyFood = null;
        this.powerUp = null;

        progressBarController.reset();
        progressBarController.isFinish.set(false);

        companyFoodTimeLine.playFromStart();
        powerUpTimeLine.playFromStart();
        pause.set(false);
    }

    // This function calls in each frame.
    @Override
    public void handle(long currentTime){

        // Check current timePeriod and
        if ( (currentTime - framePrevTime) < speedNanoSecond || pause.get() ) return;

        // Action.
        updateFrame();

        // Check is death.
        if (!snake.isSafe() || progressBarController.isFinish.get()) {
            Painter.showGameOver(gameWindow.getCanvas().getGraphicsContext2D());
            pause.set(true);
        }

        // Update stamina.
        if (!snake.getSnakeDirection().equals(Directions.START)) progressBarController.update();

        framePrevTime = currentTime;
        String status = "";



        // Check food counter.
        status += " " + foodCounter;
        if (foodCounter == 5) {

            Platform.runLater(() -> {
                snake = LevelUpScreen.modifySnake(snake);
                pause.set(false);
            });
            pause.set(true);
            foodCounter = 0;

        }
        // Point
        status += " " + bank + " " + snake.getMultiplier();
        gameWindow.getScoreTable().setText("Stat : " + status);

    }

    private void updateFrame() {

        // Clear canvas
        gameWindow.getCanvas().getGraphicsContext2D().clearRect(0,0,R.GAME_SCREEN_WIDTH,R.GAME_SCREEN_HEIGHT);

        // Check is snake eat food ?
        if (isSnakeEatFood(food)) {

            ++foodCounter;
            bank += snake.getMultiplier() * 10;
            snake.extend(rowNumber,colNumber);
            food = new Food(Point.getRandomPoint(rowNumber, colNumber, snake.getPoints()));

        }else {
            snake.move(rowNumber,colNumber);
        }



        List<AbstractFood>foods = new ArrayList<>();
        foods.add(food);
        if (companyFoodRandomTimer.getIsAvailable())
            foods.add(companyFood);
        if (powerUpRandomTimer.getIsAvailable()){
            foods.add(powerUp);

        }

        Painter.paint(gameWindow,snake,foods);

        // Check is snake dead ?


    }


    private boolean isSnakeEatFood(AbstractFood food) {
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
        AtomicBoolean isFinish = new AtomicBoolean(false);

        ProgressBarController(ProgressBar progressBar, double totalTime) {

            this.progressBar = progressBar;

            this.timePeriod = 1.0 / totalTime;
            this.currentTime = totalTime;
            this.totalTime  = totalTime;

        }

        void update() {
            if (!isFinish.get()){
                progressBar.setProgress(currentTime / totalTime);
                currentTime -= timePeriod;
                if (currentTime < 0)
                    isFinish.set(true);
            }
        }

        public void showCurrentProgress(){
            progressBar.setProgress(currentTime / totalTime);
        }

        public void reset(){
            currentTime = totalTime;
        }
    }

    private class RandomTimer {

        private int stayingTimeLowerBound;
        private int stayingTimeUpperBound;
        private int stayingTime;

        private int creatingTimeLowerBound;
        private int creatingTimeUpperBound;
        private int creatingTime;

        private Random random;

        private AtomicBoolean isAvailable;

        private boolean orderFlag = true; // false ise staying time true ise creating time.

        public RandomTimer(int stayingTimeLowerBound, int stayingTimeUpperBound,
                           int creatingTimeLowerBound, int creatingTimeUpperBound) {

            this.stayingTimeLowerBound = stayingTimeLowerBound;
            this.stayingTimeUpperBound = stayingTimeUpperBound;
            this.creatingTimeLowerBound = creatingTimeLowerBound;
            this.creatingTimeUpperBound = creatingTimeUpperBound;
            isAvailable = new AtomicBoolean();
            isAvailable.set(false);
            random = new Random();
            stayingTime     = random.nextInt(stayingTimeUpperBound-stayingTimeLowerBound) + stayingTimeLowerBound;
            creatingTime    = random.nextInt(creatingTimeUpperBound-creatingTimeLowerBound) + creatingTimeLowerBound;
        }

        public int getRandomTime() {

            int temp;

            if (orderFlag) {
                temp = creatingTime;
                System.out.println(creatingTimeUpperBound + " " + creatingTimeLowerBound);
                creatingTime    = random.nextInt(creatingTimeUpperBound-creatingTimeLowerBound) + creatingTimeLowerBound;

            }else {
                temp = stayingTime;
                stayingTime = random.nextInt(stayingTimeUpperBound - stayingTimeLowerBound) + stayingTimeLowerBound;
            }
            orderFlag = !orderFlag;

            return temp;
        }

        public int getRandomTimeSecure(){
            return creatingTime;
        }

        public void setStayingTimeLowerBound(int stayingTimeLowerBound) {
            this.stayingTimeLowerBound = stayingTimeLowerBound;
        }

        public void setStayingTimeUpperBound(int stayingTimeUpperBound) {
            this.stayingTimeUpperBound = stayingTimeUpperBound;
        }

        public void setCreatingTimeLowerBound(int creatingTimeLowerBound) {
            this.creatingTimeLowerBound = creatingTimeLowerBound;
        }

        public void setCreatingTimeUpperBound(int creatingTimeUpperBound) {
            this.creatingTimeUpperBound = creatingTimeUpperBound;
        }

        public void switchIsAvailable() {
            this.isAvailable.set(!isAvailable.get());
        }

        public Boolean getIsAvailable() {
            return isAvailable.get();
        }
    }
}
