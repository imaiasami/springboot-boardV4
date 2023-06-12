package com.example.login.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.login.model.Reply;

@Mapper
public interface ReplyMapper {
	// 리플 등록
	void saveReply(Reply reply);

	// 리플 전체 목록
	List<Reply> findReplies(Long board_id);

	// 리플 하나 읽기
	Reply findReply(Long reply_id);

	// 리플 수정

	// 리플 삭제
}
