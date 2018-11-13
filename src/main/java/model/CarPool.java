package model;

import app.Logger;
import services.carloader.CarLoader;

import java.util.Iterator;
import java.util.List;

public class CarPool
{
    private List<Car> cars;

    private CarLoader loader;

    public CarPool(CarLoader loader)
    {
        this.loader = loader;
        this.cars = loader.load();

        Logger.getInstance().log("Loaded cars: " + cars.size());
    }

    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
