package viewcontroller;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import model.Car;
import model.CarPool;

import java.util.Iterator;

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
    private TableView<Car> tableCars;

    @FXML
    private TableColumn<Car, Boolean> colSelected;

    @FXML
    private TableColumn<Car, String> colID;

    @FXML
    private TableColumn<Car, String> colDisplayName;

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

    private ObservableList<Car> getCarList() {
        ObservableList<Car> cars = FXCollections.observableArrayList();

        Iterator<Car> it = carPool.iterator();
        while (it.hasNext()) {
            cars.add(it.next());
        }
        return cars;
    }

    private void initializeCarTable() {
        ObservableList<Car> cars = getCarList();

        colSelected.setCellFactory(CheckBoxTableCell.forTableColumn(colSelected));
        colSelected.setEditable(true);
        colID.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().getId()));
        colDisplayName.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().getDisplayName()));

        tableCars.setItems(cars);
        tableCars.getSelectionModel().selectedItemProperty().addListener(this::onCarSelected);
        tableCars.getSelectionModel().select(0);
    }

    private void onCarSelected(Observable observable) {
        Car selectedCar = tableCars.getSelectionModel().getSelectedItem();
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
        initializeCarTable();
    }
}
