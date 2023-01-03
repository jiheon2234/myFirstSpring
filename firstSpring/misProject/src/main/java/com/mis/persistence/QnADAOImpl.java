package com.mis.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.QnAVO;
import com.mis.domain.SearchCriteria;

@Repository
public class QnADAOImpl implements QnADAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.mis.mapper.QnaMapper";

	@Override
	public void create(QnAVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public QnAVO read(int qnaNo) throws Exception {
		return session.selectOne(namespace + ".read", qnaNo);
	}

	@Override
	public void update(QnAVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(int qnaNo) throws Exception {
		session.delete(namespace + ".delete", qnaNo);

	}

	@Override
	public List<QnAVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearchCriteria", cri);
	}

	@Override
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCountCriteria", cri);
	}

	@Override
	public void updateHits(int qnaNo) throws Exception {
		session.update(namespace + ".updateHits", qnaNo);

	}

}
