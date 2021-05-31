package aps.financemanagerdesktop.controller.model;

import aps.financemanagerdesktop.entity.Category;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryModel {
    private StringProperty propId;
    private StringProperty propDescription;

    public CategoryModel(){
        this(new Category());
    }

    public CategoryModel(final Category category){
        propId = new SimpleStringProperty(category.getId().toString());
        propDescription = new SimpleStringProperty(category.getDescription());
    }

    public String id(){
        return propId.get();
    }

    public void id(final String value){
        propId.set(value);
    }

    public String description(){
        return propDescription.get();
    }

    public void description(final String value){
        propDescription.set(value);
    }
}