package com.mis.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mis.domain.ReplyVO;
import com.mis.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Inject
	private ReplyDAO dao;

	@Override
	public void add(ReplyVO vo) throws Exception {
		dao.create(vo);
		
	}

	@Override
	public void remove(int replyNo) throws Exception {
		dao.delete(replyNo);
		
	}

	@Override
	public void removeAll(int qnaNo) throws Exception {
		dao.deleteAll(qnaNo);
		
	}

	@Override
	public List<ReplyVO> list(int qnaNo) throws Exception {
		return dao.list(qnaNo);
	}

}
