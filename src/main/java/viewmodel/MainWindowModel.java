package viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Car;
import model.CarPool;

import java.util.Iterator;

public class MainWindowModel
{
    private ObservableList<CarTableModel> cars = FXCollections.observableArrayList();

    public void setCars(CarPool carPool) {
        Iterator<Car> it = carPool.iterator();
        while (it.hasNext()) {
            cars.add(new CarTableModel(it.next()));
        }
    }

    public ObservableList<CarTableModel> getCars() {
        return cars;
    }
}
