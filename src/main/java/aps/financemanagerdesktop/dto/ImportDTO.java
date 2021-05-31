package aps.financemanagerdesktop.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import aps.financemanagerdesktop.enums.Operation;
import aps.financemanagerdesktop.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImportDTO {
	private LocalDate entryDate;
	private String category;
	private String account;
	private Operation operation;
	private PaymentType paymentType;
	private String card;
	private BigDecimal value;
	private String observation;
}