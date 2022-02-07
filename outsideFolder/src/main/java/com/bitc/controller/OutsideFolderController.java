package com.bitc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OutsideFolderController {
	
	@RequestMapping("/out/outsideFolder.do")
	public String outsideFolder() throws Exception {
		return "/out/outsideFolder";
	}
}
