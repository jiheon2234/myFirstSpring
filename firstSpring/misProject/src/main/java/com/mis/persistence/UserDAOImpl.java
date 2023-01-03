package com.mis.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace="com.mis.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		
		return session.selectOne(namespace+".login",dto);
	}

	@Override
	public void create(UserVO vo) throws Exception {
		session.insert(namespace+".create",vo);
		
	}

	@Override
	public UserVO read(String usid) throws Exception {
		
		return session.selectOne(namespace+".read");
	}

	@Override
	public void update(UserVO vo) throws Exception {
		
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(String usid) throws Exception {
		
		session.delete(namespace+".delete",usid);
	}

	@Override
	public List<UserVO> ListSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".listSearchCriteria", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCountCriteria", cri);

	}

}
