package JobHunt.resources;

import javafx.scene.paint.Color;

public enum Companies {
    GOOGLE(Color.AZURE),
    MICROSOFT(Color.AQUAMARINE);

    private final Color color;

    private Companies(final Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
