package JobHunt.resources;

import JobHunt.Main.Game.Core.DecoratorPattern.Anaconda;
import JobHunt.Main.Game.Core.DecoratorPattern.Python;
import JobHunt.Main.Game.Core.DecoratorPattern.Snake;
import JobHunt.Main.Game.Core.SNAKE_TYPES;
import JobHunt.Main.R;

public class SnakeForest {

    public static Snake catchSnake(String snakeType) {

        System.out.println();
        if (snakeType.contains(SNAKE_TYPES.Anaconda.getSnakeName()))
            return new Anaconda();
        else if (snakeType.contains(SNAKE_TYPES.Python.getSnakeName()))
            return new Python();

        return null;

    }
}
