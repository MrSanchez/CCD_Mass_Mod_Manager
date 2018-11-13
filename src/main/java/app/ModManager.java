package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CarPool;
import services.carloader.CarLoader;
import viewcontroller.MainController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ModManager extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.displayScreen("frame.fxml", new MainController());
        StatusManager.getInstance().displayStatus(StatusType.SUCCESS, "Application launched");

        CarPool carPool = new CarPool(new CarLoader());

        Scene scene = new Scene(sceneManager.getDisplayNode(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
