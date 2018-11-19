package viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.image.Image;
import model.Car;
import model.CarProperty;
import org.controlsfx.control.PropertySheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarTableModel
{
    private Car car;
    private BooleanProperty selected = new SimpleBooleanProperty();

    public CarTableModel(Car car) {
        this.car = car;
    }

    public List<PropertySheet.Item> getPropertySheet() {
        List<PropertySheet.Item> properties = new ArrayList<>();

        Iterator<CarProperty> it = this.car.propertiesIterator();
        while(it.hasNext()) {
            CarProperty property = it.next();
            properties.add(new CarPropertySheetItem(property));
        }
        return properties;
    }

    public boolean isSelected() {
        return selected.get();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    public String getId() {
        return car.getId();
    }

    public String getDisplayName() {
        return car.getDisplayName();
    }

    public String getDescription() {
        return car.getDescription();
    }

    public Image getPrimaryImage() {
        return car.getPrimaryImage();
    }
}
