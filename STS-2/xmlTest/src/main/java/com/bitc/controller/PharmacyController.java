package com.bitc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.common.PharmacyUrlParser;
import com.bitc.dto.PharmacyFullDataItemDto;
import com.bitc.service.PharmacyService;

@Controller
public class PharmacyController {

	@Autowired
	private PharmacyService pharmacyService;
	
	@Autowired
	private PharmacyUrlParser urlParser;

	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}

	@RequestMapping(value = "/pharmacy/fulldata", method = RequestMethod.GET)
	public ModelAndView getFullData() throws Exception {
		ModelAndView mv = new ModelAndView("/pharmacy/fullData");

		List<PharmacyFullDataItemDto> itemList = pharmacyService.getItemList();
		mv.addObject("pharmacyDatas", itemList);
		return mv;
	}

	@RequestMapping("/pharmacy/pharmacySearchUrl")
	public String getCovid19InfoUrlInput() throws Exception {
		return "/pharmacy/pharmacyInfoUrlInput";
	}

	@RequestMapping("/pharmacy/pharmacyResultUrl")
	public ModelAndView getPharmacyInfoUrl(@RequestParam("q0") String q0, @RequestParam("q1") String q1,
			@RequestParam("qT") String qT, @RequestParam("qN") String qN) throws Exception {
		ModelAndView mv = new ModelAndView("/pharmacy/pharmacyInfoUrl");
		String q00 = null;
		String q01 = null;
		String q0N = null;

		try {
			q00 = URLEncoder.encode(q0, "UTF-8");
			q01 = URLEncoder.encode(q1, "UTF-8");
			q0N = URLEncoder.encode(qN, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		String endPoint = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService";
		String serviceFunc = "/getParmacyListInfoInqire";
		String keyFunc = "?serviceKey=";
		String Q0 = "&Q0=";
		String Q1 = "&Q1=";
		String QT = "&QT=";
		String QN = "&QN=";
		String ORD = "&ORD=NAME";
		String pageNo = "&pageNo=1";
		String rows = "&numOfRows=10";
		String serviceKey = "jTrcdKem5RUjq2w7BYfEe6F%2FWAJeveuQRbqFpw67CA1LrYeYLVjUv99EclTO45kB98rK3mmG5X6Qm32lHiHr%2Bw%3D%3D";

		String strUrl = endPoint + serviceFunc + keyFunc + serviceKey + Q0 + q00 + Q1 + q01 + QT + qT + QN + q0N + ORD
				+ pageNo + rows;

		List<PharmacyFullDataItemDto> itemList = pharmacyService.getItemListRange(strUrl);
		mv.addObject("pharmacyDatas", itemList);

		return mv;
	}
	
//	ajax 통신을 위해서 필요한 사용자 입력 화면을 보기 위한 부분
	@RequestMapping(value="/pharmacy/pharmacyinfoUrlAjax", method=RequestMethod.GET)
	public String getCovid19InfoUrlInputAjax() throws Exception {
		return "/pharmacy/pharmacyinfoUrlAjax";
	}
	
//	실제 ajax 통신을 위한 데이터 전송 부분
	@ResponseBody
	@RequestMapping(value="/pharmacy/pharmacyinfoUrlAjax", method=RequestMethod.POST)
	public Object getPharmacyInfoUrlAjax(@RequestParam("q0") String q0, @RequestParam("q1") String q1,
			@RequestParam("qT") String qT, @RequestParam("qN") String qN) throws Exception {
		String strUrl = urlParser.getPharmacyUrl(q0, q1, qT, qN);
		
		List<PharmacyFullDataItemDto> itemList = pharmacyService.getItemListRange(strUrl);
		
		return itemList;
	}
}
