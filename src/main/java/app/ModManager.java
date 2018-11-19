package app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CarPool;
import services.carloader.CarLoader;
import viewcontroller.CarInfoTab;
import viewcontroller.CarPropertiesTab;
import viewcontroller.MainWindowView;
import viewmodel.MainWindowModel;

import java.io.IOException;

public class ModManager extends Application
{
    SceneManager sceneManager = SceneManager.getInstance();
    StatusManager statusManager = StatusManager.getInstance();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        showMainWindow();
        statusManager.displayStatus(StatusType.SUCCESS, "Application launched");

        Scene scene = new Scene(sceneManager.getDisplayNode(), 800, 600);
        primaryStage.setTitle("CCD Mass Mod Manager 0.1 by MrSanchez");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showMainWindow() {
        MainWindowModel model = getMainWindowViewModel();

        Parent infoTabContent = sceneManager.loadScreen(FXMLViews.MAINWINDOW_TAB_CARINFO, new CarInfoTab(model));
        Parent propertiesTabContent = sceneManager.loadScreen(FXMLViews.MAINWINDOW_TAB_CARPROPERTIES, new CarPropertiesTab(model));

        MainWindowView view = new MainWindowView(model);
        Parent mainWindowNode = sceneManager.loadScreen(FXMLViews.MAINWINDOW, view);

        view.setInfoTabContent(infoTabContent);
        view.setPropertiesTabContent(propertiesTabContent);

        sceneManager.displayScreen(mainWindowNode);
    }

    private MainWindowModel getMainWindowViewModel() {
        CarPool carPool = new CarPool(new CarLoader());
        MainWindowModel model = new MainWindowModel();
        model.setCars(carPool);
        return model;
    }
}
