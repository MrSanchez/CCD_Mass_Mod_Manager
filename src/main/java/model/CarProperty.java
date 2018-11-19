package model;

public class CarProperty
{
    private String category;
    private String key;
    private String value;

    public CarProperty(String category, String key, String value) {
        this.category = category;
        this.key = key;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
