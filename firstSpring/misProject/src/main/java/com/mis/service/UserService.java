package com.mis.service;

import java.util.List;

import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;

public interface UserService {

	public UserVO login(LoginDTO dto) throws Exception;

	public void register(UserVO vo) throws Exception;

	public UserVO read(String usid) throws Exception;

	public void modify(UserVO vo) throws Exception;

	public void remove(String usid) throws Exception;

	// 페이징, 검색 기능을 제공하는 list 가져오는 기능
	public List<UserVO> listSearch(SearchCriteria cri) throws Exception;

	// 페이징, 검색 기능 게시물 수 가져오는 기능
	public int listSearchCount(SearchCriteria cri) throws Exception;
}
