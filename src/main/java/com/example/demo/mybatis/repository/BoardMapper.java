package com.example.demo.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.mybatis.model.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> selectAllBoard();
	void saveArticle(BoardVO vo);
}
