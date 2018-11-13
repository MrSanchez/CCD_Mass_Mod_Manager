package services.carloader;

import app.Constants;
import model.Car;
import utils.PathUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Loads all necessary data for a non-Steam-workshop car mod into a Car model
 */
public class NonSteamCarLoader
{
    public List<Car> load() {
/*        try {
            List<File> steamCarFiles = Files.walk(Paths.get(PathUtils.fromGameDir(Constants.PATH_STEAM_USER_CARS)))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return new ArrayList<>();
    }
}
