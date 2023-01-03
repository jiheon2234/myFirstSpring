package com.mis.persistence;

import java.util.List;

import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto) throws Exception; //로그인
	
	public void create(UserVO vo) throws Exception; //회원가입
	
	public UserVO read(String usid) throws Exception; //정보
	
	public void update(UserVO vo) throws Exception;
	
	public void delete(String usid) throws Exception; //삭제
	
	public List<UserVO> ListSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	
}
