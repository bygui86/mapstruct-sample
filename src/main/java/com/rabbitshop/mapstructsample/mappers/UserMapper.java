package com.rabbitshop.mapstructsample.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.rabbitshop.mapstructsample.daos.Address;
import com.rabbitshop.mapstructsample.daos.User;
import com.rabbitshop.mapstructsample.dtos.UserDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	/**
	 * Convert an User (DAO) to an UserDTO
	 *
	 * @param dao
	 *
	 * @return {@link com.rabbitshop.mapstructsample.dtos.UserDto}
	 */
	@Mapping(target = "name", expression = "java( dao.getFirstName() + \" \" + dao.getLastName() )")
	@Mapping(source = "email.emailAddress", target = "email")
	UserDto mapToDto(User dao);
	
	default String mapUserName(final String firstName, final String lastName) {
		
		return firstName + " " + lastName;
	}
	
	/**
	 * Mapping
	 * [source] streetName + streetNumber + , + zipCode + city + - + country
	 * [target] address
	 */
	default String mapDaoAddress(final Address address) {
		
		final StringBuilder strBuilder = new StringBuilder();
		if (address != null) {
			strBuilder.append(address.getStreetName());
			strBuilder.append(" ");
			strBuilder.append(address.getStreetNumber());
			strBuilder.append(", ");
			strBuilder.append(address.getZipcode());
			strBuilder.append(" ");
			strBuilder.append(address.getCity());
			strBuilder.append(" (");
			strBuilder.append(address.getCountry());
			strBuilder.append(")");
		}
		
		return strBuilder.toString();
	}

	/**
	 * Convert an UserDTO to an User (DAO)
	 *
	 * @param dto
	 *
	 * @return {@link com.rabbitshop.mapstructsample.daos.User}
	 */
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "firstName", expression = "java( dto.getName().split(\" \")[0].trim() )")
	@Mapping(target = "lastName", expression = "java( dto.getName().split(\" \")[1].trim() )")
	@Mapping(target = "email.verified", expression = "java( Boolean.FALSE.booleanValue() )")
	@InheritInverseConfiguration
	User mapToDao(UserDto dto);
	
	/**
	 * Mapping
	 * [source] address
	 * [target] streetName + streetNumber + , + zipCode + city + - + country
	 */
	default Address mapDtoAddress(final String address) {
		
		// split somehow :) not relevant for this test

		return null;
	}

}
