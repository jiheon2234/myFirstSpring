package com.mis.service;

import java.util.List;

import com.mis.domain.ReplyVO;

public interface ReplyService {

	public void add(ReplyVO vo) throws Exception;

	public void remove(int replyNo) throws Exception;

	public void removeAll(int qnaNo) throws Exception;

	public List<ReplyVO> list(int qnaNo) throws Exception;

}
