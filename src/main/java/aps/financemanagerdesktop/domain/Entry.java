package aps.financemanagerdesktop.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entry extends BaseEntity{
	private LocalDate entryDate;
	private Category category;
	private Account account;
	private Operation operation;
	private PaymentType paymentType;
	private Card card;
	private BigDecimal value;
	private String observation;
}