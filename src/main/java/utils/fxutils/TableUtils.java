package utils.fxutils;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableUtils
{
    public static <T, E> TableColumn<T, E> createIndexColumn() {
        TableColumn<T, E> indexColumn = new TableColumn<>("#");
        indexColumn.setCellFactory(new LineNumbersCellFactory<>(1));
        indexColumn.setSortable(false);
        return indexColumn;
    }
}
