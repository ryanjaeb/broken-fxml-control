import control.BrokenPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        BrokenPane brokenPane = new BrokenPane();

        BorderPane borderPane = new BorderPane(brokenPane);

        primaryStage.setTitle("Custom Component");
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}