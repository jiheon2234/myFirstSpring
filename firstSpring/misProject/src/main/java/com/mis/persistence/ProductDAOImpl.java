package com.mis.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.mis.mapper.ProductMapper";

	@Override
	public void create(ProductVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public ProductVO read(int pno) throws Exception {
		return session.selectOne(namespace + ".read", pno);
	}

	@Override
	public void update(ProductVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(int pno) throws Exception {
		session.delete(namespace + ".delete", pno);

	}

	@Override
	public List<ProductVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearchCriteria", cri);
	}

	@Override
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCountCriteria", cri);
	}

	@Override
	public void updateViewCount(int pno) throws Exception {
		session.update(namespace + ".updateViewCount", pno);
	}

}
