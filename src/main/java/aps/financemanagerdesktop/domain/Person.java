package aps.financemanagerdesktop.domain;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Person {
    private StringProperty nameProperty;
    private StringProperty lastNameProperty;
    private ObjectProperty<LocalDate> birthdayProperty;

    public Person(){
        this(null, null, null);
    }

    public Person(final String name, final String lastName, final LocalDate birthday){
        this.nameProperty     = new SimpleStringProperty(name);
        this.lastNameProperty = new SimpleStringProperty(lastName);
        this.birthdayProperty = new SimpleObjectProperty<>(birthday);
    }

    public String name(){
        return this.nameProperty.get();
    }

    public void name(final String name){
        this.nameProperty.set(name);
    }

    public String lastName(){
        return this.lastNameProperty.get();
    }

    public void lastName(final String lastName){
        this.lastNameProperty.set(lastName);
    }

    public LocalDate birthday(){
        return this.birthdayProperty.get();
    }

    public void birthday(final LocalDate birthday){
        this.birthdayProperty.set(birthday);
    }
}