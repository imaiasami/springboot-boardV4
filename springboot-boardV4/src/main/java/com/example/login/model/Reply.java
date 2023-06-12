package com.example.login.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Reply {

	private Long reply_id;
	private Long board_id;
	private String id;
	private String content;
	@DateTimeFormat
	private LocalDateTime input_date;

	public Reply(Long board_id, String id, String content) {
		this.board_id = board_id;
		this.id = id;
		this.content = content;
	}

}
