package viewcontroller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Car;
import model.CarPool;

import java.util.Iterator;
import java.util.List;

public class MainController
{
    private final CarPool carPool;


    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuFile;

    @FXML
    private Menu menuHelp;

    @FXML
    private Tab tabMain;

    @FXML
    private ListView<Car> listCars;

    @FXML
    private ImageView imageCar;

    @FXML
    private Label lblCarID;

    @FXML
    private Label lblCarDisplayName;

    @FXML
    private Label lblCarDescription;

    @FXML
    private Tab tabSecondary;

    public MainController(CarPool carPool) {
        this.carPool = carPool;
    }

    private void initializeCarList() {
        ObservableList<Car> cars = FXCollections.observableArrayList();

        Iterator<Car> it = carPool.iterator();
        while (it.hasNext()) {
            cars.add(it.next());
        }

        listCars.setItems(cars);
        listCars.getSelectionModel().selectedItemProperty().addListener(this::onCarSelected);
        listCars.getSelectionModel().select(0);
    }

    private void onCarSelected(Observable observable) {
        Car selectedCar = listCars.getSelectionModel().getSelectedItem();
        this.updateCarDetails(selectedCar);
    }


    private void updateCarDetails(Car car) {
        this.updateCarImage(car);

        // MODEL
        lblCarID.setText(car.getId());
        lblCarDisplayName.setText(car.getDisplayName());
        lblCarDescription.setText(car.getDescription());
    }

    private void updateCarImage(Car car)
    {
        imageCar.setImage(car.getPrimaryImage());
    }

    @FXML
    private void initialize() {
        initializeCarList();
    }
}
