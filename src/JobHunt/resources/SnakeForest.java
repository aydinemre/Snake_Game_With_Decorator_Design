package JobHunt.resources;

import JobHunt.Main.Game.Core.DecoratorPattern.Anaconda;
import JobHunt.Main.Game.Core.DecoratorPattern.Python;
import JobHunt.Main.Game.Core.DecoratorPattern.Snake;
import JobHunt.Main.Game.Core.SNAKE_TYPES;
import JobHunt.Main.R;

public class SnakeForest {

    public static Snake catchSnake(String snakeType) {

        System.out.println(snakeType);
        if (SNAKE_TYPES.valueOf(snakeType) == SNAKE_TYPES.Anaconda)
            return new Anaconda();
        else if (SNAKE_TYPES.valueOf(snakeType) == SNAKE_TYPES.Python)
            return new Python();

        return null;

    }
}
