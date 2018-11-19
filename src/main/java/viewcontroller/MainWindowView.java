package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import viewmodel.MainWindowModel;

public class MainWindowView
{
    private final MainWindowModel model;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuFile;

    @FXML
    private Menu menuHelp;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabInfo;

    @FXML
    private Tab tabProperties;

    public MainWindowView(MainWindowModel model) {
        this.model = model;
    }

    public void setInfoTabContent(Node contentNode) {
        tabInfo.setContent(contentNode);
    }

    public void setPropertiesTabContent(Node contentNode) {
        tabProperties.setContent(contentNode);
    }

    @FXML
    private void initialize() {

    }
}
