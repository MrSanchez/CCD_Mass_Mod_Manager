package utils.fxutils;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.AbstractPropertyEditor;

public class CarPropertyEditor extends AbstractPropertyEditor<String, TextField>
{
    public CarPropertyEditor(PropertySheet.Item property, TextField control) {
        super(property, control);
    }

    @Override
    protected ObservableValue getObservableValue() {
        return this.getEditor().textProperty();
    }


    @Override
    public void setValue(String s) {
        this.getEditor().setText(s);
    }
}
