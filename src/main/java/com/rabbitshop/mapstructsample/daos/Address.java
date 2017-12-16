package com.rabbitshop.mapstructsample.daos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields, and @RequiredArgsConstructor
@Builder
public class Address {

	private String streetName;
	
	private long streetNumber;

	private String city;

	private long zipcode;

	private String country;

}
