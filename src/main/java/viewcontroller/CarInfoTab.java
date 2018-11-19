package viewcontroller;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import utils.fxutils.TableUtils;
import viewmodel.CarTableModel;
import viewmodel.MainWindowModel;

public class CarInfoTab
{
    private final MainWindowModel model;

    @FXML
    private TableView<CarTableModel> tableCars;

    @FXML
    private TableColumn<CarTableModel, String> colID;

    @FXML
    private TableColumn<CarTableModel, String> colDisplayName;

    @FXML
    private ImageView imageCar;

    @FXML
    private Label lblCarID;

    @FXML
    private Label lblCarDisplayName;

    @FXML
    private Label lblCarDescription;

    public CarInfoTab(MainWindowModel model) {
        this.model = model;
    }


    private void initializeCarTableListeners() {
        for (CarTableModel car : model.getCars()) {
            car.selectedProperty().addListener(this::onCarTableChanged);
        }
        tableCars.getSelectionModel().selectedItemProperty().addListener(this::onCarTableChanged);
    }

    private void initializeCarTable() {
        initializeCarTableColumns();
        initializeCarTableListeners();

        tableCars.setItems(model.getCars());
        tableCars.getSelectionModel().select(0);
    }

    private void initializeCarTableColumns() {
        colID.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().getId()));
        colDisplayName.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().getDisplayName()));

        TableColumn<CarTableModel, String> indexColumn = TableUtils.createIndexColumn();
        indexColumn.setMaxWidth(40);
        tableCars.getColumns().add(0, indexColumn);
    }

    private void onCarTableChanged(Observable observable) {
        CarTableModel selectedCar = tableCars.getSelectionModel().getSelectedItem();

        updateCarDetails(selectedCar);
    }

    private void updateCarDetails(CarTableModel car) {
        imageCar.setImage(car.getPrimaryImage());
        lblCarID.setText(car.getId());
        lblCarDisplayName.setText(car.getDisplayName());
        lblCarDescription.setText(car.getDescription());
    }

    @FXML
    private void initialize() {
        initializeCarTable();
    }
}
