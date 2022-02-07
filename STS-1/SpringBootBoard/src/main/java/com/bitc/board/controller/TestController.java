package com.bitc.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.board.dto.CalculatorDto;

@Controller
public class TestController {
// @Controller 어노테이션을 해당 매서드에 반환타입을 String으로 지정했을 경우 템플릿의 위치를 지정한 것으로 간주함
	@RequestMapping("/test/test1")
	public String test1() throws Exception {
		return "test/test1";
	}

	@RequestMapping("/test/calculator.do")
	public String inputPage()  {
		return "test/calculator";
	}

	@RequestMapping("/test/calculatorProcess.do")
	public ModelAndView inputPageProcess(CalculatorDto dto) {
		ModelAndView mv = new ModelAndView("/test/calculatorProcess");

		dto.setResult(dto.getNum1() + dto.getNum2());
		
		mv.addObject("data", dto);
		
		return mv;
	}
	
	@RequestMapping("/test/calculatorProcess2.do")
	public ModelAndView inputPageProcess(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		ModelAndView mv = new ModelAndView("/test/calculatorProcess2");

		int result = num1 + num2;
		
		mv.addObject("num1", num1);
		mv.addObject("num2", num2);
		mv.addObject("result", result);
		
		return mv;
	}
}
