package com.bitc.quizkdh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.quizkdh.dto.QuizBoardDto;
import com.bitc.quizkdh.service.QuizBoardService;

@Controller
public class QuizBoardController {

	@Autowired
	private QuizBoardService quizBoardService;

	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView quizBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("/quiz/boardList");

		List<QuizBoardDto> boardList = quizBoardService.viewBoardList();
		mv.addObject("boardList", boardList);

		return mv;
	}
	
	@RequestMapping(value="/boardList/write", method=RequestMethod.GET)
	public String boardWrite() throws Exception {
		return "/quiz/boardWrite";
	}
	
	@RequestMapping(value="/boardList/write", method=RequestMethod.POST)
	public String boardInsert(QuizBoardDto quizBoard) throws Exception {
		quizBoardService.boardInsert(quizBoard);
		
		return "redirect:/boardList";
	}
	
	@RequestMapping(value="/boardList/{idx}", method=RequestMethod.GET)
	public ModelAndView boardDetails(@PathVariable("idx") int idx) throws Exception {
		ModelAndView mv = new ModelAndView("/quiz/boardDetails");
		
		QuizBoardDto quizBoard =quizBoardService.viewBoardDetails(idx);
		mv.addObject("quizBoard", quizBoard);
		
		return mv;
	}
	
	@RequestMapping(value="/boardList/{idx}", method=RequestMethod.PUT)
	public String boardEdit(QuizBoardDto quizBoard) throws Exception {
		quizBoardService.boardEdit(quizBoard);
		
		return "redirect:/boardList";
	}
	
	@RequestMapping(value="/boardList/delete/{idx}", method=RequestMethod.DELETE)
	public String boardDelete(@PathVariable("idx") int idx) throws Exception {
		quizBoardService.boardDelete(idx);
		
		return "redirect:/boardList";
	}
}
