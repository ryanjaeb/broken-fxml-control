package fxml;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoaderUtils {
    public static <T> T load(Object fxmlControl, LoaderConfig config) {
        assert config != null;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(config.getLocation());
        loader.setRoot(fxmlControl);
        loader.setClassLoader(fxmlControl.getClass().getClassLoader());

        Optional<ControllerFactory> factory = config.getControllerFactory();
        if (factory.isPresent()) {
            loader.setControllerFactory(factory.get());
        }

        Optional<ResourceBundle> bundle = config.getResourceBundle();
        if (bundle.isPresent()) {
            loader.setResources(bundle.get());
        }

        try {
            Object root = loader.load();
            assert root == fxmlControl;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load control using LoaderUtils.", e);
        }

        return loader.getController();
    }

    public static <T> T load(Object root) {
        return load(root, new DefaultLoaderConfig(root));
    }
}
