package viewcontroller;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import org.controlsfx.control.PropertySheet;
import utils.fxutils.CarPropertyEditor;
import utils.fxutils.CarSelectionChangeEvent;
import viewmodel.CarPropertySheetItem;
import viewmodel.CarTableModel;
import viewmodel.MainWindowModel;

import javax.xml.soap.Text;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarPropertiesTab
{
    private final MainWindowModel model;

    private List<WeakReference<TextField>> propertyFields;

    @FXML
    private Label lblSelectedCount;

    @FXML
    private Button btnSelectAll;

    @FXML
    private Button btnDeselectAll;

    @FXML
    private Button btnInvertSelection;

    @FXML
    private TableView<CarTableModel> tableCars;

    @FXML
    private TableColumn<CarTableModel, Boolean> colSelected;

    @FXML
    private TableColumn<CarTableModel, String> colID;

    @FXML
    private TableColumn<CarTableModel, String> colDisplayName;

    @FXML
    private PropertySheet propertySheet;

    public CarPropertiesTab(MainWindowModel model) {
        this.model = model;
        this.propertyFields = new ArrayList<>();
    }

    private void initializeCarTableListeners() {
        for (CarTableModel car : model.getCars()) {
            car.selectedProperty().addListener(this::onCarSelected);
        }
        tableCars.getSelectionModel().selectedItemProperty().addListener(this::onCarTableChanged);
    }

    private void onCarSelected(Observable observable) {
        //updatePropertyFields(); // todo - fix. textfield text immediately goes into model. Placeholder '-' needs different impl
        onCarTableChanged(observable);
    }

    private void initializeCarTable() {
        colSelected.setCellValueFactory(p -> p.getValue().selectedProperty());
        colSelected.setCellFactory(CheckBoxTableCell.forTableColumn(colSelected));
        colSelected.setEditable(true);

        colID.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().getId()));
        colDisplayName.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().getDisplayName()));

        tableCars.setItems(model.getCars());
        initializeCarTableListeners();
        tableCars.getSelectionModel().select(0);
    }


    private void onCarTableChanged(Observable observable) {
        CarTableModel selectedCar = tableCars.getSelectionModel().getSelectedItem();
        if(selectedCar != null) {
            propertySheet.getItems().clear();
            propertySheet.getItems().addAll(selectedCar.getPropertySheet());

            CarPropertySheetItem debugItem = (CarPropertySheetItem) propertySheet.getItems().get(0);
            System.out.println(debugItem.debugGetValue());
        }
        this.updateSelectedCarsCount();
        //this.updateCarPropertiesTable();
    }

    private int countSelectedCars() {
        int count = 0;
        for(CarTableModel car : tableCars.getItems()) {
            if(car.isSelected()) count++;
        }
        return count;
    }

    private void updateSelectedCarsCount() {
        int selectedCount = countSelectedCars(),
            totalCarCount = model.getCars().size();
        lblSelectedCount.setText(String.format("%d out of %d cars selected", selectedCount, totalCarCount));
    }

    @FXML
    private void initialize() {
        initializeCarTable();
        propertySheet.setPropertyEditorFactory(item -> {
            TextField textField = new TextField();
            propertyFields.add(new WeakReference<>(textField));
            return new CarPropertyEditor(item, textField);
        });
    }

    private void updatePropertyFields() {
        System.out.println(propertyFields.size());
        Iterator<WeakReference<TextField>> it = propertyFields.iterator();
        while (it.hasNext()) {
            WeakReference<TextField> ref = it.next();
            if(ref.get() == null) {
                it.remove();
            } else {
                updatePropertyField(ref.get());
            }
        }
    }

    private void updatePropertyField(TextField textField) {
        if(countSelectedCars() > 1) {
            //System.out.println("-");
            textField.setText(" - ");
        } else {
            //System.out.println("Selection < 1");
            // Todo Set cached text
        }
    }

    @FXML
    private void onSelectAllButtonClicked() {
        // Todo move this logic to viewmodel
        for(CarTableModel car : tableCars.getItems()) {
            car.setSelected(true);
        }
    }

    @FXML
    private void onDeselectAllButtonClicked() {
        for(CarTableModel car : tableCars.getItems()) {
            car.setSelected(false);
        }
    }

    @FXML
    private void onInvertSelectionButtonClicked() {
        for(CarTableModel car : tableCars.getItems()) {
            car.setSelected(!car.isSelected());
        }
    }

}
