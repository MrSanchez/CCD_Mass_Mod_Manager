package model;

import app.Logger;
import services.carloader.CarLoader;

import java.util.Iterator;
import java.util.List;

public class CarPool
{
    private List<Car> cars;

    private CarLoader carLoader;

    public CarPool(CarLoader carLoader) {
        this.carLoader = carLoader;
        this.loadCars();

        Logger.getInstance().log("Loaded cars: " + cars.size());
    }

    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public int size() {
        return cars.size();
    }

    public void loadCars() {
        this.cars = carLoader.load();
    }
}
