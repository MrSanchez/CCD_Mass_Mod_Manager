package app;

import exceptions.LoadingScreenException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Window;

import java.io.IOException;

public class SceneManager
{
    public static final String resourcesDir = "/fxml/"; // Relative to src folder

    private static SceneManager uniqueInstance = new SceneManager();

    private StatusManager statusManager;
    private BorderPane displayNode;
    private StackPane centerPane; // primary screen layer

    private SceneManager() {
        displayNode = new BorderPane();
        centerPane = new StackPane();
        statusManager = StatusManager.getInstance();

        displayNode.setCenter(centerPane);
        displayNode.setBottom(statusManager.getStatusBar());

        statusManager.displayStatus(StatusType.INFORMATION, "Setting up scene manager.");
    }

    public static SceneManager getInstance() {
        return uniqueInstance;
    }

    /**
     * Loads a screen from a FXML file and returns its root node.
     * @param resource Name of the FXML file to load
     * @param viewController Reference to a FXML viewcontroller which should handle viewcontroller events.
     * @return Parent root node of the newly loaded screen.
     * @throws LoadingScreenException when FXML file can not be loaded through the FXML loader.
     */
    public Parent loadScreen(String resource, Object viewController) {
        // Retrieve FXML file from disk and set its FXML viewcontroller-controller.
        FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(resourcesDir + resource));
        loader.setController(viewController);

        try {
            return loader.load();
        } catch (IOException e) {
            throw new LoadingScreenException("Can't load new screen: " + resource);
        }
    }

    /**
     * Switches the currently displayed screen to another one loaded from a FXML file.
     * @param resource Name of the FXML file to load
     * @param viewController Reference to a FXML viewcontroller which should handle viewcontroller events.
     */
    public void displayScreen(String resource, Object viewController) {
        Parent screenContentNode = this.loadScreen(resource, viewController);
        this.displayScreen(screenContentNode);
    }

    /**
     * Switches the currently displayed screen to another one loaded from a FXML file.
     * @param screenContentNode Root node of the screen to display
     */
    public void displayScreen(Parent screenContentNode) {
        statusManager.displayStatus(StatusType.NONE, "");
        this.showNode(screenContentNode);
    }

    /**
     * Used on launch for adding displayNode to JavaFX scene graph
     * @return Returns the main display Node containing all screen layers.
     */
    public Parent getDisplayNode() {
        return displayNode;
    }

    private void showNode(Parent rootNode) {
        // Optional: Fade out
        centerPane.getChildren().clear();

        // Optional: Fade in
        centerPane.getChildren().add(rootNode);
    }
}
