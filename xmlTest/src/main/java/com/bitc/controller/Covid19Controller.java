package com.bitc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.common.UrlParser;
import com.bitc.dto.Covid19DataItemDto;
import com.bitc.service.Covid19Service;

@Controller
public class Covid19Controller {

	@Autowired
	private Covid19Service covid19Service;

	@Autowired
	private UrlParser urlParser;
	
	@RequestMapping(value = "/covid19/toDayInfo", method = RequestMethod.GET)
	public ModelAndView getTodayInfo() throws Exception {
		ModelAndView mv = new ModelAndView("/covid19/toDayInfo");

		List<Covid19DataItemDto> itemList = covid19Service.getItemList();
		mv.addObject("covid19Datas", itemList);
		return mv;
	}

	@RequestMapping("/covid19/toDayInfoUrlInput")
	public String getCovid19InfoUrlInput() throws Exception {
		return "/covid19/covid19InfoUrlInput";
	}

	@RequestMapping("/covid19/toDayInfoUrl")
	public ModelAndView getCovid19InfoUrl(@RequestParam("startDt") String startDt, @RequestParam("endDt") String endDt) throws Exception {
		ModelAndView mv = new ModelAndView("/covid19/covid19InfoUrl");

		String endPoint = "http://openapi.data.go.kr/openapi/service/rest/Covid19";
		String serviceFunc = "/getCovid19InfStateJson";
		String keyFunc = "?serviceKey=";
		String pageNo = "&pageNo=1";
		String rows = "&numOfRows=10";
		String startCreateDt = "&startCreateDt=";
		String endCreateDt = "&endCreateDt=";

		String serviceKey = "jTrcdKem5RUjq2w7BYfEe6F%2FWAJeveuQRbqFpw67CA1LrYeYLVjUv99EclTO45kB98rK3mmG5X6Qm32lHiHr%2Bw%3D%3D";

		String strUrl = endPoint + serviceFunc + keyFunc + serviceKey + pageNo + rows + startCreateDt + startDt + endCreateDt + endDt;

		List<Covid19DataItemDto> itemList = covid19Service.getItemListRange(strUrl);
		mv.addObject("covid19Datas", itemList);
		
		return mv;
	}
	
//	ajax ????????? ????????? ????????? ????????? ?????? ????????? ?????? ?????? ??????
	@RequestMapping(value="/covid19/covid19infoUrlAjax", method=RequestMethod.GET)
	public String getCovid19InfoUrlInputAjax() throws Exception {
		return "/covid19/covid19infoUrlAjax";
	}
	
//	?????? ajax ????????? ?????? ????????? ?????? ??????
	@ResponseBody
	@RequestMapping(value="/covid19/covid19infoUrlAjax", method=RequestMethod.POST)
	public Object getCovid19InfoUrlAjax(@RequestParam("startDt") String startDt, @RequestParam("endDt") String endDt) throws Exception {

		String strUrl = urlParser.getUrl(startDt, endDt);
		
		List<Covid19DataItemDto> itemList = covid19Service.getItemListRange(strUrl);
		
		return itemList;
	}
}
