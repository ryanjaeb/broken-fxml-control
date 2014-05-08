package fxml;

import java.net.URL;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;

public class DefaultLoaderConfig implements LoaderConfig {
    private final Object fxmlRoot;
    private final Optional<ControllerFactory> optionalFactory = Optional.empty();

    public DefaultLoaderConfig(final Object fxmlRoot) {
        this.fxmlRoot = fxmlRoot;
    }

    @Override
    public URL getLocation() {
        Class rootClass = fxmlRoot.getClass();
        String simpleClassName = rootClass.getSimpleName();
        String fxmlPath = simpleClassName + ".fxml";

        return rootClass.getResource(fxmlPath);
    }

    @Override
    public Optional<ResourceBundle> getResourceBundle() {
        Class rootClass = fxmlRoot.getClass();
        String packageName = rootClass.getPackage().getName();
        String simpleClassName = rootClass.getSimpleName();
        String pathFormat = "%s.i18n.%s";
        String bundlePath = String.format(pathFormat, packageName, simpleClassName);

        try {
            return Optional.of(ResourceBundle.getBundle(bundlePath));
        } catch (MissingResourceException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ControllerFactory> getControllerFactory() {
        return optionalFactory;
    }
}
