package aps.financemanagerdesktop.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import aps.financemanagerdesktop.enums.Operation;
import aps.financemanagerdesktop.enums.PaymentType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
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