package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import model.CarProperty;
import org.controlsfx.control.PropertySheet;

import java.util.Optional;

public class CarPropertySheetItem implements PropertySheet.Item
{
    private CarProperty carProperty;
    private SimpleStringProperty valueProperty;

    public CarPropertySheetItem(CarProperty carProperty) {
        this.carProperty = carProperty;
        this.valueProperty = new SimpleStringProperty(carProperty, "value");
    }

    public String debugGetValue() {
        return carProperty.getValue();
    }

    @Override
    public Class<?> getType() {
        return String.class;
    }

    @Override
    public String getCategory() {
        return carProperty.getCategory();
    }

    @Override
    public String getName() {
        return carProperty.getKey();
    }

    @Override
    public String getDescription() {
        return carProperty.getKey();
    }

    @Override
    public Object getValue() {
        return carProperty.getValue();
    }

    @Override
    public void setValue(Object o) {
        carProperty.setValue(o.toString());
    }

    @Override
    public Optional<ObservableValue<? extends Object>> getObservableValue() {
        return Optional.of(valueProperty);
    }
}
