package com.mis.persistence;

import java.util.List;

import com.mis.domain.ReplyVO;

public interface ReplyDAO {

	public void create(ReplyVO vo) throws Exception;

	public void delete(int replyNo) throws Exception;

	public void deleteAll(int qnaNo) throws Exception;

	public List<ReplyVO> list(int qnaNo) throws Exception;

}
