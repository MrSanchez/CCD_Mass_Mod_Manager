package utils.fxutils;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class LineNumbersCellFactory<T, E> implements Callback<TableColumn<T, E>, TableCell<T, E>>
{
    private final int startOffset;

    public LineNumbersCellFactory(int startOffset) {
        this.startOffset = startOffset;
    }

    @Override
    public TableCell<T, E> call(TableColumn<T, E> param) {
        return new TableCell<T, E>() {

            @Override
            protected void updateItem(E item, boolean empty) {
                super.updateItem(item, empty);

                if (!empty) {
                    if(this.getTableRow() != null) {
                        setText(this.getTableRow().getIndex() + startOffset + "");
                    }
                } else {
                    setText("");
                }
            }
        };
    }
}