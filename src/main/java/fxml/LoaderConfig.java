package fxml;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public interface LoaderConfig {
    URL getLocation();
    Optional<ResourceBundle> getResourceBundle();
    Optional<ControllerFactory> getControllerFactory();
}
