package com.mis.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mis.domain.ReplyVO;
import com.mis.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Inject
	private ReplyService service;

	// 댓글 등록
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) {

		ResponseEntity<String> entity = null;

		try {
			service.add(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	// 댓글 삭제
	@RequestMapping(value = "/{replyNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("replyNo") int replyNo) {
		ResponseEntity<String> entity = null;

		try {

			service.remove(replyNo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	// 전체 댓글 목록
	@RequestMapping(value = "/all/{qnaNo}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("qnaNo") int qnaNo) {
		ResponseEntity<List<ReplyVO>> entity = null;

		try {

			service.list(qnaNo);
			entity = new ResponseEntity<>(service.list(qnaNo), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

}
