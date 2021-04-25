package aps.spreadsheetimporter.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card extends BaseEntity{
	private CardType cardType;
	private String name;
	private Flag flag;
	private int closingDay;
	private int payDay;
	private LocalDate expirationDate;
}