package com.bitc.kdh.service;

import java.util.List;

import com.bitc.kdh.dto.AddressDto;

public interface AddressService {

	List<AddressDto> selectAddressList() throws Exception;
	
	void insertAddress(AddressDto address) throws Exception;
	
	AddressDto selectAddressDetail(int seq) throws Exception;

	void deleteAddress(int seq) throws Exception;

	void updateAddress(AddressDto address) throws Exception;
}
