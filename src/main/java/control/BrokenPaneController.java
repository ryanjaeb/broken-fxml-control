package control;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.HTMLEditor;

public class BrokenPaneController {
    @FXML
    private BorderPane rootPane;
    @FXML
    void initialize() {
        assert (rootPane != null) : "The variable rootPane must not be null.";

        HTMLEditor editor = new HTMLEditor();
        rootPane.setCenter(editor);

        // This causes a NPE when running in SceneBuilder
        // Comment it out and the custom control will work
        editor.getHtmlText();
    }
}