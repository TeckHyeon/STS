package com.bitc.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.board.dto.BoardDto;
import com.bitc.board.dto.BoardFileDto;
import com.bitc.board.service.BoardService;
import com.github.pagehelper.PageInfo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {

		ModelAndView mv = new ModelAndView("/board/boardList");

		List<BoardDto> boardList = boardService.selectBoardList();

		mv.addObject("boardList", boardList);

		return mv;
	}

	@RequestMapping("/board/writeBoard.do")
	public String writeBoard() throws Exception {

		return "/board/writeBoard";
	}

	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board, MultipartHttpServletRequest multiFiles) throws Exception {

		boardService.insertBoard(board, multiFiles);

		return "redirect:/board/openBoardList.do";
	}

	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam("idx") int idx) throws Exception {
		ModelAndView mv = new ModelAndView("/Board/boardDetail");

		BoardDto board = boardService.selectBoardDetail(idx);

		mv.addObject("board", board);

		return mv;
	}

	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception {

		boardService.updateBoard(board);

		return "redirect:/board/openBoardList.do";
	}

	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(@RequestParam("idx") int idx) throws Exception {

		boardService.deleteBoard(idx);

		return "redirect:/board/openBoardList.do";
	}

	@RequestMapping("/board/downloadBoardFile.do")
	public void downloadBoardFile(@RequestParam int fileIdx, @RequestParam int boardIdx, HttpServletResponse response)
			throws Exception {
		BoardFileDto boardFile = boardService.selectBoardFileInfo(fileIdx, boardIdx);

		if (ObjectUtils.isEmpty(boardFile) == false) {
			String fileName = boardFile.getOriginalFileName();

			byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));

			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);
			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");

			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
	
	@RequestMapping("/page/boardlist")
	public ModelAndView paging(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
		ModelAndView mv = new ModelAndView("/board/pagingBoardList");
		
		PageInfo<BoardDto> page = new PageInfo<>(boardService.pagingBoardList(pageNum), 5);
		mv.addObject("board", page);
		return mv;
	}
}
