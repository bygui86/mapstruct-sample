package com.rabbitshop.mapstructsample.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rabbitshop.mapstructsample.daos.Address;
import com.rabbitshop.mapstructsample.dtos.AddressDto;

/**
 * The @Mapper annotation causes the MapStruct code generator to create an implementation of the CarMapper interface at compile time.
 */
@Mapper
public interface AddressMapper {

	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
	
	/**
	 * Convert an Address (DAO) to an AddressDTO
	 *
	 * Using Java 8 or later, you can omit the @Mappings wrapper annotation and directly specify several
	 * @Mapping annotations on one method.
	 *
	 * @param dao
	 *
	 * @return {@link com.rabbitshop.mapstructsample.dtos.AddressDto}
	 */
	// @Mapping(source = "qax", target = "baz")
	// @Mapping(source = "baz", target = "qax")
	AddressDto mapToDto(Address dao);

	/**
	 * Convert an AddressDTO to an Address (DAO)
	 *
	 * @param dto
	 *
	 * @return {@link com.rabbitshop.mapstructsample.daos.Address}
	 */
	@InheritInverseConfiguration
	Address mapToDao(AddressDto dto);
	
}
