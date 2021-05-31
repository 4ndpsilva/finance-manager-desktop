package aps.financemanagerdesktop.entity;

import java.time.LocalDate;

import aps.financemanagerdesktop.enums.CardType;
import aps.financemanagerdesktop.enums.Flag;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Card extends BaseEntity{
	private CardType cardType;
	private String name;
	private Flag flag;
	private int closingDay;
	private int payDay;
	private LocalDate expirationDate;
}