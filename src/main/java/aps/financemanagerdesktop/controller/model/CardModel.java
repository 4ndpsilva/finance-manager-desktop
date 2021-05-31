package aps.financemanagerdesktop.controller.model;

import aps.financemanagerdesktop.entity.Card;
import aps.financemanagerdesktop.enums.CardType;
import aps.financemanagerdesktop.enums.Flag;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CardModel {
    private StringProperty propId;
    private ObjectProperty<CardType> propCardType;
    private StringProperty propName;
    private ObjectProperty<Flag> propFlag;
    private StringProperty propClosingDay;
    private StringProperty propPayDay;
    private ObjectProperty<LocalDate> propExpirationDate;

    public CardModel(){
        this(new Card());
    }

    public CardModel(final Card card){
        propId = new SimpleStringProperty(card.getId().toString());
        propCardType = new SimpleObjectProperty<>(card.getCardType());
        propName = new SimpleStringProperty(card.getName());
        propFlag = new SimpleObjectProperty<>(card.getFlag());
        propClosingDay = new SimpleStringProperty(String.valueOf(card.getClosingDay()));
        propPayDay = new SimpleStringProperty(String.valueOf(card.getPayDay()));
        propExpirationDate = new SimpleObjectProperty<>(card.getExpirationDate());
    }
}