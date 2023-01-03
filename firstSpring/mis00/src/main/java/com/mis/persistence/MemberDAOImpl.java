package com.mis.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.mis.mapper.MemberMapper";

	@Override
	public String getTime() {
		
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember",vo);
		
	}

	@Override
	public MemberVO readMember(String userid) {
		
		return sqlSession.selectOne(namespace+".readMember",userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) {
		
//		//문제정의 : select() 파라미터를 1개만 보낼 수 있음
//		
//		//1) MemberVO를 선언해서 담아보낸다.
//		MemberVO mVO = new MemberVO();
//		mVO.setUserid(userid);
//		mVO.setUserpwd(userpw);
//		return sqlSession.selectOne(namespace+".readWithPW",mVO);
		
		//2) 자바에서 사용하는 컬렉션 사용 (효율적)
		HashMap<String, Object>paramMap = new HashMap<String,Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace+".readWithPW",paramMap);
	}
	

}
