package JobHunt.Main;

import java.io.File;
import java.security.cert.Certificate;

public interface R {

    // Game Window Width.
    int GAME_SCREEN_WIDTH = 600;

    // Game Window height.
    int GAME_SCREEN_HEIGHT = 600;

    // One cell size.
    int CELL_SCALE = 15;

    // Game start speed.
    int GAME_START_SPEED = 100;

    String iconPath = ".." + File.separator + "resources" + File.separator + "Images" + File.separator + "GameIcon.jpg";

    enum DECORATORS{ Internship, Training_Certificate, Foreign_Language}
}
