package com.mis.service;

import java.util.List;

import com.mis.domain.QnAVO;
import com.mis.domain.SearchCriteria;

public interface QnAService {
	
	public void register(QnAVO vo) throws Exception;
	
	public QnAVO read(int qnaNo) throws Exception;
	
	public void modify(QnAVO vo) throws Exception;
	
	public void remove(int qnaNo) throws Exception;
	
	public List<QnAVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;

}
