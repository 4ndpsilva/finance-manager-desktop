package aps.financemanagerdesktop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Account extends BaseEntity{
	private String name;

	private Category category;
}