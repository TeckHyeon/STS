package com.bitc.quizkdh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitc.quizkdh.dto.QuizBoardDto;
import com.bitc.quizkdh.service.QuizBoardService;

@RestController
public class QuizApiBoardController {

	@Autowired
	private QuizBoardService quizBoardService;

	@RequestMapping(value = "/api/boardList", method = RequestMethod.GET)
	public List<QuizBoardDto> quizBoardList() throws Exception {

		return quizBoardService.viewBoardList();
	}
	
	@RequestMapping(value="/api/boardList/{idx}", method=RequestMethod.POST)
	public void boardInsert(@RequestBody QuizBoardDto quizBoard) throws Exception {
		quizBoardService.boardInsert(quizBoard);

	}
	
	@RequestMapping(value="/api/boardList/{idx}", method=RequestMethod.GET)
	public QuizBoardDto boardDetails(@PathVariable("idx") int idx) throws Exception {

		return quizBoardService.viewBoardDetails(idx);
	}
	
	@RequestMapping(value="/api/boardList/{idx}", method=RequestMethod.PUT)
	public String boardEdit(@RequestBody QuizBoardDto quizBoard) throws Exception {
		quizBoardService.boardEdit(quizBoard);
		
		return "redirect:/boardList";
	}
	
	@RequestMapping(value="/api/boardList/{idx}", method=RequestMethod.DELETE)
	public String boardDelete(@PathVariable("idx") int idx) throws Exception {
		quizBoardService.boardDelete(idx);
		
		return "redirect:/boardList";
	}
}
