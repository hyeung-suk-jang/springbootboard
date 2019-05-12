package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
