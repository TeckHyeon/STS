package com.bitc.kdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.kdh.dto.AddressDto;
import com.bitc.kdh.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public List<AddressDto> selectAddressList() throws Exception {
		
		return addressMapper.selectAddressList();
	}
	@Override
	public void insertAddress(AddressDto address) throws Exception {
		addressMapper.insertAddress(address);
	}
	
	@Override
	public AddressDto selectAddressDetail(int seq) throws Exception {
		
		AddressDto address = addressMapper.selectAddressDetail(seq);
		return address;
	}
	
	@Override
	public void deleteAddress(int seq) throws Exception {
		addressMapper.deleteAddress(seq);
	}
	@Override
	public void updateAddress(AddressDto address) throws Exception {
		addressMapper.updateAddress(address);
	}
}
