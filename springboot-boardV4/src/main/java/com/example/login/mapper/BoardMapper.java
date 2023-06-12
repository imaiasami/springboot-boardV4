package com.example.login.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.login.model.Board;

@Mapper
public interface BoardMapper {
	
	// 게시글 전체 검색
	List<Board> findAllBoards();
	// 게시글 등록
	int writeBoard(Board board);
	// 게시글 검색
	Board findBoardById(Long board_id);
	// 게시글 수정
	int updateBoard(Board board);
	// 게시글 삭제
	int removeBoard(Long board_id);
}
