package services.carloader;

import javafx.scene.image.Image;
import model.Car;

import java.util.ArrayList;
import java.util.List;


public class CarLoader
{
    public List<Car> load() {
        List<Car> cars = new ArrayList<>();

        NonSteamCarLoader nonSteamLoader = new NonSteamCarLoader();
        SteamCarLoader steamLoader = new SteamCarLoader();

        cars.addAll(nonSteamLoader.load());
        cars.addAll(steamLoader.load());

        loadCarsPrimaryImage(cars);
        return cars;
    }

    private void loadCarsPrimaryImage(List<Car> cars) {
        for(Car car : cars) {
            Image image = ImageLoader.getPrimaryImage(car.getId());
            if(image != null) car.setPrimaryImage(image);
        }
    }
/*
    private void loadAllCarImages(List<Car> cars) {
        for(Car car : cars) {
            List<Image> images = ImageLoader.getAllImages(car.getId());
            if(!images.isEmpty()) {
                car.setPrimaryImage(images.get(0));
            }
        }
    }*/
}
