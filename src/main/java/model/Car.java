package model;

import javafx.scene.image.Image;

public class Car
{
    private String id;
    private String displayName;
    private String description;

    private String soundBankName;
    private Image primaryImage;


    public Car(String id, String displayName, String description)
    {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
    }

    public Car()
    {

    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getSoundBankName()
    {
        return soundBankName;
    }

    public void setSoundBankName(String soundBankName)
    {
        this.soundBankName = soundBankName;
    }

    public Image getPrimaryImage()
    {
        return primaryImage;
    }

    public void setPrimaryImage(Image primaryImage)
    {
        this.primaryImage = primaryImage;
    }
}
