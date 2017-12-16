package com.rabbitshop.mapstructsample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rabbitshop.mapstructsample.daos.Address;
import com.rabbitshop.mapstructsample.daos.Email;
import com.rabbitshop.mapstructsample.daos.User;
import com.rabbitshop.mapstructsample.dtos.AddressDto;
import com.rabbitshop.mapstructsample.dtos.UserDto;
import com.rabbitshop.mapstructsample.example.Source;
import com.rabbitshop.mapstructsample.example.SourceTargetMapper;
import com.rabbitshop.mapstructsample.example.Target;
import com.rabbitshop.mapstructsample.mappers.AddressMapper;
import com.rabbitshop.mapstructsample.mappers.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MapStructApplication implements CommandLineRunner {
	
	private static final String EMPTY_STRING = "";

	public static void main(final String[] args) {
		
		SpringApplication.run(MapStructApplication.class, args);
	}
	
	@Override
	public void run(final String... args) throws Exception {

		simpleTest();

		addressTest();
		
		userTest();
	}

	protected static void userTest() {

		final Email emailDao = Email.builder().emailAddress("rabbit@rabbitshop.com").verified(true).build();
		final Address addressDao = Address.builder().streetName("Langstrasse").streetNumber(101).city("Zurich").zipcode(8005).country("Switzerland").build();
		final User userDao = User.builder().id("00000001").firstName("Matteo").lastName("Baiguini").email(emailDao).address(addressDao).build();

		final UserDto userDto = UserMapper.INSTANCE.mapToDto(userDao);

		log.info(EMPTY_STRING);
		log.info(EMPTY_STRING);
		log.info("User DAO: " + userDao);
		log.info(EMPTY_STRING);
		log.info("User DTO: " + userDto);
		log.info(EMPTY_STRING);
		log.info(EMPTY_STRING);
	}
	
	protected static void addressTest() {
		
		final Address dao = Address.builder().streetName("Langstrasse").streetNumber(101).city("Zurich").zipcode(8005).country("Switzerland").build();
		
		final AddressDto dto = AddressMapper.INSTANCE.mapToDto(dao);
		
		log.info(EMPTY_STRING);
		log.info(EMPTY_STRING);
		log.info("Address DAO: " + dao);
		log.info(EMPTY_STRING);
		log.info("Address DTO: " + dto);
		log.info(EMPTY_STRING);
		log.info(EMPTY_STRING);
	}

	protected void simpleTest() {

		final Source source = new Source();
		source.setFoo(42);
		source.setBar(23L);
		source.setBaz(86L);
		source.setQax(66);
		source.setZip(73);

		final Target target = SourceTargetMapper.INSTANCE.sourceToTarget(source);

		log.info(EMPTY_STRING);
		log.info(EMPTY_STRING);
		log.info("Source class: " + source);
		log.info(EMPTY_STRING);
		log.info("Target class: " + target);
		log.info(EMPTY_STRING);
		log.info(EMPTY_STRING);
	}
	
}
