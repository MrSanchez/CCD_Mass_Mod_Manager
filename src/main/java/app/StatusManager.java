package app;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class StatusManager
{
    public static final String resourcesDir = "main/java/resources/fxml/"; // Relative to src folder

    private static StatusManager uniqueInstance = new StatusManager();

    private Label statusLabel;

    private StatusManager() {
        initializeStatusBar();

        this.displayStatus(StatusType.INFORMATION, "Setting up statusbar manager.");
    }

    public static StatusManager getInstance() {
        return uniqueInstance;
    }

    public Label getStatusBar() {
        return statusLabel;
    }

    /**
     * Changes the text and color on the bottom status bar.
     * @param statusType The colour used for the status bar.
     * @param statusMsg message to display on the status bar
     */
    public void displayStatus(StatusType statusType, String statusMsg) {
        statusLabel.setText(statusMsg);
        statusLabel.setBackground(getStatusBarBackgroundColor(statusType));
    }

    private void initializeStatusBar() {
        statusLabel = new Label();
        statusLabel.setPadding(new Insets(0, 0,0,5));
        statusLabel.setMaxWidth(Double.MAX_VALUE);
    }

    private Background getStatusBarBackgroundColor(StatusType statusType) {
        Color color = new Color(0, 0, 0, 0);
        switch(statusType) {
            case CRITICAL: color = new Color(0.7, 0,0, 1); break;
            case SUCCESS: color = new Color(0, 0.7,0, 1); break;
            case WARNING: color = new Color(0.7, 0.6,0, 1); break;
            case INFORMATION: color = new Color(0, 0.5,0.7, 1); break;
            case NONE: color = new Color(0, 0,0, 0); break;
        }
        return new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY));
    }
}
