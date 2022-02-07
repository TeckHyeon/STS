package com.bitc.kdh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.kdh.dto.AddressDto;

@Mapper
public interface AddressMapper {

	List<AddressDto> selectAddressList() throws Exception;
	
	void insertAddress(AddressDto address) throws Exception;
	
	AddressDto selectAddressDetail(int seq) throws Exception;

	void deleteAddress(int seq) throws Exception;
	
	void updateAddress(AddressDto address) throws Exception;
}
