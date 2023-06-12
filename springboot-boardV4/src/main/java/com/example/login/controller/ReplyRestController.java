package com.example.login.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.login.mapper.ReplyMapper;
import com.example.login.model.Member;
import com.example.login.model.Reply;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("reply")
@RestController
public class ReplyRestController {

	private final ReplyMapper replyMapper;
	// 생성자 주입은 final로 받아라

	// 리플 등록
	@PostMapping("write")
	public ResponseEntity<Reply> writeReply(
			@SessionAttribute(name = "loginMember", required = false) Member loginMember, @ModelAttribute Reply reply) {
		log.info("reply: {}", reply);
		// reply 추가 정보 셋팅
		reply.setId(loginMember.getId());

		replyMapper.saveReply(reply);

		return ResponseEntity.ok(reply);

	}

	// 리플 전체 목록
	@GetMapping("findReplies")
	public ResponseEntity<List<Reply>> findReplies(@RequestParam Long board_id,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {
		log.info("board_id {}", board_id);

		List<Reply> replies = replyMapper.findReplies(board_id);
		
		return ResponseEntity.ok(replies);
	}

	// 리플 하나 읽기

	// 리플 수정

	// 리플 삭제
}
