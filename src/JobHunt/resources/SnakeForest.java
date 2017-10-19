package JobHunt.resources;

import JobHunt.Main.Game.DecoratorPattern.Anaconda;
import JobHunt.Main.Game.DecoratorPattern.Python;
import JobHunt.Main.Game.DecoratorPattern.Snake;
import JobHunt.Main.R;

public class SnakeForest {

    public static Snake catchSnake(String snakeType) {

        if (R.SNAKE_TYPES.valueOf(snakeType) == R.SNAKE_TYPES.Anaconda)
            return new Anaconda();
        else if (R.SNAKE_TYPES.valueOf(snakeType) == R.SNAKE_TYPES.Python)
            return new Python();

        return null;

    }
}
