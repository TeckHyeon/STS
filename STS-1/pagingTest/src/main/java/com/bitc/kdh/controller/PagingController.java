package com.bitc.kdh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.kdh.dto.EmployeesDto;
import com.bitc.kdh.service.PageService;
import com.github.pagehelper.PageInfo;

@Controller
public class PagingController {

	@Autowired PageService pageService;
	
	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}
//	required=false : 해당 매개변수가 없이 접속했을 경우 오류를 발생시키지 않음
//	defaultValue : 기본 값 설정
	@RequestMapping("/page")
	public ModelAndView paging(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
		ModelAndView mv = new ModelAndView("/page");
		
//		PageInfo : 페이지 헬퍼가 가지고 있는 현재 상태 클래스, List하고 비슷
//		--------------- PageInfo의 요소들 ---------------
//		pageNum : int 형식, 현재 페이지를 뜻한다, 
//		pageSize : int 형식, 페이지 수량을 뜻한다, 
//		size : int 형식, 현재 페이지 수를 뜻한다, 
//		startRow : long 형식, 현재 페이지의 첫번째 요소가 데이터베이스에 있는 줄번호를 뜻한다,
//		endRow : long 형식, 현재 페이지의 마지막 요소가 데이터베이스에 있는 줄번호를 뜻한다, 
//		pages : int 형식, 전체 페이지 수, 
//		prePage : int 형식, 이전 페이지, 
//		pages : int 형식, 다음 페이지, 
//		isFirstPage = false : boolean, 첫번째 페이지 여부
//		isLastPage = false : boolean, 마지막 페이지 여부
//		haspreviousPage = false : boolean, 이전 페이지 존재 여부
//		hasNextPage = false : boolean, 다음 페이지 존재 여부
//		navigatePages = int, 내비게이션 페이지 번호
//		navigatePageNums = int[], 모든 내비게이션 페이지 번호
//		navigateFirstPage = int, 내비게이션 바의 첫 페이지
//		navigateLastPage = int, 내비게이션 바의 마지막 페이지
		
		PageInfo<EmployeesDto> page = new PageInfo<>(pageService.selectEmpList(pageNum), 10);
		mv.addObject("users", page);
		return mv;
	}
}
