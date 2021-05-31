package aps.financemanagerdesktop.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ListUtil {
    public static <M, T> ObservableList<M> toObservableList(final List<T> list){
        final ObservableList<M> observableList = FXCollections.observableArrayList();
        return observableList;
    }
}