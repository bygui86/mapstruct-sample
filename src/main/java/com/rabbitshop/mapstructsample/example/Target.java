package com.rabbitshop.mapstructsample.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields, and @RequiredArgsConstructor
@Builder
public class Target {
	
	private Long foo;
	
	private int bar;
	
	private Long baz;
	
	private int qax;
	
	private String zip;

}
