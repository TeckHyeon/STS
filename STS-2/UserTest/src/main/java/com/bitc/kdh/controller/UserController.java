package com.bitc.kdh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.kdh.dto.CalDto;
import com.bitc.kdh.dto.UserDto;
import com.bitc.kdh.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String ajaxCalculatorInput() throws Exception {
		return "/index";
	}
	
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Object ajaxCalculatorResult(CalDto cal) throws Exception {
		HashMap<String, Object> calResult = new HashMap<String, Object>();
		calResult.put("num1", cal.getNum1());
		calResult.put("num2", cal.getNum2());
		calResult.put("operator", cal.getOperator());
		switch (cal.getOperator()) {
		case "+":
			calResult.put("result", cal.getNum1() + cal.getNum2());
		break;
		
		case "-":
			calResult.put("result", cal.getNum1() - cal.getNum2());
		break;
			
		case "×":
			calResult.put("result", cal.getNum1() * cal.getNum2());
		break;
			
		case "÷":
			calResult.put("result", cal.getNum1() / cal.getNum2());
		break;
		}

		return calResult;
	}

	@RequestMapping("/UserList.do")
	public ModelAndView UserList() throws Exception {

		ModelAndView mv = new ModelAndView("/user/userList");

		List<UserDto> userList = userService.selectUserList();

		mv.addObject("userList", userList);

		return mv;
	}

	@RequestMapping(value="/createUser.do", method=RequestMethod.GET)
	public String createUser() throws Exception {

		return "/user/userRegistration";
	}

	@ResponseBody
	@RequestMapping(value = "/createUserNum.do", method = RequestMethod.POST)
	public Object createUserNum(String userPhone1) throws Exception {
		List<String> listCode = new ArrayList<String>();
		listCode.add("02");
		listCode.add("051");
		listCode.add("033");
		listCode.add("010");
		listCode.add("011");
		listCode.add("017");

		return listCode;
	}

	@ResponseBody
	@RequestMapping(value="/createUserInt", method=RequestMethod.POST)
	public Object createUserInt(@RequestParam("userInt1") String userInt1) throws Exception {
		List<String> listInter = new ArrayList<String>();
		
		if (userInt1.equals("스포츠")) {
			listInter.add("농구");
			listInter.add("축구");
			listInter.add("야구");
			listInter.add("골프");
			listInter.add("헬스");
		}
		else if (userInt1.equals("게임")) {
			listInter.add("온라인게임");
			listInter.add("모바일게임");
			listInter.add("보드게임");
			listInter.add("미니어쳐 게임");
			listInter.add("콘솔 게임");
		}
		else {
			listInter.add("그림");
			listInter.add("프로그래밍");
			listInter.add("작곡");
			listInter.add("작문");
			listInter.add("DIY");
		}
		
		return listInter;
	}
	@RequestMapping("/insertUser.do")
	public String insertUser(UserDto user) throws Exception {

		userService.insertUser(user);

		return "redirect:/UserList.do";
	}

	@RequestMapping("/userDetail.do")
	public ModelAndView userDetail(@RequestParam("userSeq") int userSeq) throws Exception {
		ModelAndView mv = new ModelAndView("/user/userDetail");

		UserDto user = userService.selectUserDetail(userSeq);

		mv.addObject("user", user);

		return mv;
	}

	@RequestMapping("/updateUser.do")
	public String updateUser(UserDto user) throws Exception {

		userService.updateUser(user);

		return "redirect:/UserList.do";
	}

	@RequestMapping("/deleteUser.do")
	public String deleteUser(@RequestParam("seq") int seq) throws Exception {

		userService.deleteUser(seq);

		return "redirect:/UserList.do";
	}
}
