package com.mis.persistence;

import java.util.List;

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;
import com.mis.domain.SearchCriteria;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;

	public BoardVO read(int bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(int bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	// 페이징 기능 추가
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;
	
	// 검색 기능 추가
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception;
	
	//조회수 DAO -> mapper -> DAOImpl -> ServiceImpl에서 method 추가
	
	
}
