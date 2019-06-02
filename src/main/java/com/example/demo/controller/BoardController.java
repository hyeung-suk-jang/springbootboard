package com.example.demo.controller;

import com.example.demo.mybatis.model.BoardVO;
import com.example.demo.service.BoardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

	private org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService boardservice;

	private static Logger logger = (Logger) LogManager.getLogger(BoardController.class);

	@RequestMapping(value ="list",  method={ RequestMethod.GET, RequestMethod.POST  })
	public String list(Model model) {
		logger.debug("board controller process");
		List<BoardVO> boards = boardservice.list();
		model.addAttribute("resultList", boards);
		//model.addAllAttributes(attributeValues)
		return "board/list";
	}

	@GetMapping(path = "/stat", params = "format=xls")
	public String excelDownload(Model model)
	{
		List<BoardVO> list = boardservice.list();
		model.addAttribute("list", list);
		return  "statXls";
	}

	@RequestMapping(value ="write", method={ RequestMethod.GET, RequestMethod.POST  } )
	public String write() {
		System.out.println("write call");
		return "board/write";
	}

	@RequestMapping(value="writeok", method=RequestMethod.POST)
	public String writeok(HttpServletRequest request, BoardVO vo) {
		boardservice.saveArticle(vo);
		return "redirect:/board/list";
	}

	@RequestMapping(value="detail",method={ RequestMethod.GET, RequestMethod.POST  })
	public String detail(String idx, Model model) {
		BoardVO vo = boardservice.getArticle(Integer.valueOf(idx));
		model.addAttribute("board",vo);
		return "board/detail";
	}

	@RequestMapping(value ="edit", method={ RequestMethod.GET, RequestMethod.POST  } )
	public String edit(String idx, Model model) {
		BoardVO vo = boardservice.getArticle(Integer.valueOf(idx));
		model.addAttribute("board", vo);
		return "board/edit";
	}

	@RequestMapping(value="editok", method=RequestMethod.POST)
	public String editok(HttpServletRequest request, BoardVO vo) {
		boardservice.updateArticle(vo);
		return "redirect:/board/list";
	}

	@RequestMapping(value ="delete", method={ RequestMethod.GET, RequestMethod.POST  } )
	public String delete(String idx, Model model) {
		LOGGER.info("delete");
		boardservice.delete(Integer.valueOf(idx));
		return "redirect:/board/list";
	}

}
