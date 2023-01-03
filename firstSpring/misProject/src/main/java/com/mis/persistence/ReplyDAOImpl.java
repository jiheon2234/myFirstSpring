package com.mis.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.mis.mapper.ReplyMapper";

	@Override
	public void create(ReplyVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public void delete(int replyNo) throws Exception {
		session.delete(namespace + ".delete", replyNo);

	}

	@Override
	public void deleteAll(int qnaNo) throws Exception {
		session.delete(namespace + ".deleteAll", qnaNo);

	}

	@Override
	public List<ReplyVO> list(int qnaNo) throws Exception {
		return session.selectList(namespace + ".list", qnaNo);
	}

}
