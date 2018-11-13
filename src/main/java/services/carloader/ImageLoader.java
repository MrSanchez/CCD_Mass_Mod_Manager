package services.carloader;


import app.Constants;
import javafx.scene.image.Image;
import model.Car;
import utils.PathUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Gets the display image files for the specified car
 */
public class ImageLoader
{
    public static List<Image> getAllImages(String carID) {
        List<Image> images = new ArrayList<>();

        File carImageDirectory = new File(PathUtils.fromGameDir(Constants.PATH_IMAGESETS, carID));
        File[] files = carImageDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                if ((!file.isDirectory()) && (file.getAbsolutePath().endsWith(".png"))) {
                    images.add(new Image(file.toURI().toString()));
                }
            }
        }
        return images;
    }

    public static Image getPrimaryImage(String carID) {
        File carImageDirectory = new File(PathUtils.fromGameDir(Constants.PATH_IMAGESETS, carID));
        File[] files = carImageDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                if ((!file.isDirectory()) && (file.getAbsolutePath().endsWith(".png"))) {
                    return new Image(file.toURI().toString());
                }
            }
        }
        return null;
    }
}
