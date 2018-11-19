package model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Car
{
    private String id;
    private String displayName;
    private String description;

    private String soundBankName;
    private Image primaryImage;

    private List<CarProperty> properties;


    public Car(String id, String displayName, String description) {
        this();

        this.id = id;
        this.displayName = displayName;
        this.description = description;
    }

    public Car() {
        properties = new ArrayList<>();
        properties.add(new CarProperty("common", "SoundbankFile", "oldecomoddore_v6"));
        properties.add(new CarProperty("common", "accel_rate", String.valueOf(Math.random() * 1000)));
        properties.add(new CarProperty("view", "show_character", "false"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSoundBankName() {
        return soundBankName;
    }

    public void setSoundBankName(String soundBankName) {
        this.soundBankName = soundBankName;
    }

    public Image getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(Image primaryImage) {
        this.primaryImage = primaryImage;
    }

    public Iterator<CarProperty> propertiesIterator() {
        return properties.iterator();
    }

    public void addProperty(CarProperty property) {
        properties.add(property);
    }

    public void removeProperty(CarProperty property) {
        properties.remove(property);
    }

    @Override
    public String toString() {
        return displayName;
    }
}
