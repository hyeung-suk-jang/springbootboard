package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.mybatis.model.BoardVO;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("board/")
public class BoardController {
	
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
	public String writeok(HttpServletRequest request, BoardVO vo)
	{
		//저장.
		boardservice.saveArticle(vo);
		return "redirect:list";
	}
	/*
	@RequestMapping(value="detail/{idx}",method={ RequestMethod.GET, RequestMethod.POST  })
	public String detail(@PathVariable int idx,Model model)
	{
		BoardVO vo = boardservice.getArticle(idx);
		model.addAttribute("board",vo);
		return "board/detail";
	}
	*/
	@RequestMapping(value="detail",method={ RequestMethod.GET, RequestMethod.POST  })
	public String detail(int idx,Model model)
	{
		BoardVO vo = boardservice.getArticle(idx);
		model.addAttribute("board",vo);
		return "board/detail";
	}
	
}
