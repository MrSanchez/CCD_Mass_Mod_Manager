package services.carloader;

import app.Constants;
import app.Logger;
import exceptions.XMLParseException;
import model.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utils.PathUtils;
import utils.StringUtils;
import utils.XMLUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Loads all necessary data for a Steam-workshop car mod into a Car model
 */
public class SteamCarLoader
{
    public List<Car> load() {
        List<Car> cars = new ArrayList<>();

        File userCarsDirectory = new File(PathUtils.fromGameDir(Constants.PATH_STEAM_USER_CARS));
        File[] files = userCarsDirectory.listFiles();
        for (File file : files) {
            if ((!file.isDirectory()) && (file.getAbsolutePath().endsWith(".xml"))) {
                Car car = createCar(file);
                if(car != null) {
                    cars.add(car);
                }
            }
        }
        return cars;
    }


    private Car createCar(File carFile)
    {
        Car car = null;
        try {
            Document document = XMLUtils.parseXMLDocument(carFile);
            Element carElement = (Element) document.getElementsByTagName("Car").item(0);


            String carID = PathUtils.removeFileExtension(carFile.getName());
            String displayName = StringUtils.trimEachLine(carElement.getElementsByTagName("DisplayName").item(0).getTextContent());
            String description = carElement.getElementsByTagName("Description").item(0).getTextContent();
            // Get rid of duplicate display name in description
            description = StringUtils.trimEachLine(description.substring(description.indexOf('\n', 1)+1));

            car = new Car(carID, displayName, description);
            Logger.getInstance().log(String.format("ID: %s, Name: %s", car.getId(), car.getDisplayName()));
        } catch (XMLParseException e) {
            Logger.getInstance().log(e.getMessage());
        }
        return car;
    }
}
