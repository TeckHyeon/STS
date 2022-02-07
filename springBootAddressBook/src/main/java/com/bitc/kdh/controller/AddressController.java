package com.bitc.kdh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.kdh.dto.AddressDto;
import com.bitc.kdh.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping("/openAddressList.do")
	public ModelAndView openAddressList() throws Exception {

		ModelAndView mv = new ModelAndView("/addressList");

		List<AddressDto> addressList = addressService.selectAddressList();

		mv.addObject("addressList", addressList);
		
		return mv;
	}
	
	@RequestMapping("/writeAddress.do")
	public String writeAddress() throws Exception {

		return "/writeAddress";
	}

	@RequestMapping("/insertAddress.do")
	public String insertAddress(AddressDto address) throws Exception {

		addressService.insertAddress(address);

		return "redirect:/openAddressList.do";
	}

	@RequestMapping("/openAddressDetail.do")
	public ModelAndView openAddressDetail(@RequestParam("seq") int seq) throws Exception {
		ModelAndView mv = new ModelAndView("/addressDetail");

		AddressDto address = addressService.selectAddressDetail(seq);

		mv.addObject("address", address);

		return mv;
	}
	
	@RequestMapping("/updateAddress.do")
	public String updateAddress(AddressDto address) throws Exception {

		addressService.updateAddress(address);

		return "redirect:/openAddressList.do";
	}

	@RequestMapping("/deleteAddress.do")
	public String deleteAddress(@RequestParam("seq") int seq) throws Exception {

		addressService.deleteAddress(seq);

		return "redirect:/openAddressList.do";
	}
}
