package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mybatis.model.BoardVO;
import com.example.demo.mybatis.repository.BoardMapper;


@Service
@Transactional
public class BoardService {
	@Autowired
	BoardMapper boardmapper;
	
	
	public List<BoardVO> list() {
		
		return boardmapper.selectAllBoard();
	}
	public void saveArticle(BoardVO vo) {
		boardmapper.saveArticle(vo);
	}
	public BoardVO getArticle(int idx) {
		return boardmapper.getArticle(idx);
	}
}
