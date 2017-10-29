package JobHunt.Main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;


public class MyChangeListener implements ChangeListener<Tab> {

    private static MyChangeListener ourInstance = new MyChangeListener("Python");
    private static String value;

    public static MyChangeListener getInstance() {
        return ourInstance;
    }

    private MyChangeListener(String initialValue) {
        value = initialValue;
    }

    @Override
    public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
        value = newValue.getText();
    }

    public static String getValue() {
        return value;
    }
}
