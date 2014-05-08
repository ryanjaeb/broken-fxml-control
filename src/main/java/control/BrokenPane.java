package control;

import fxml.LoaderUtils;
import javafx.scene.layout.BorderPane;

public class BrokenPane extends BorderPane {
    public BrokenPane() {
        LoaderUtils.load(this);
    }
}