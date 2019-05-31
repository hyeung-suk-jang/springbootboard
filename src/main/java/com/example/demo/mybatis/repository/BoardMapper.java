package com.example.demo.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.mybatis.model.BoardVO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardMapper {
	List<BoardVO> selectAllBoard();
	void saveArticle(BoardVO vo);
	BoardVO getArticle(int idx);
}
