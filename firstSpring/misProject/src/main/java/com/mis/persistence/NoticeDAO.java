package com.mis.persistence;

import java.util.List;

import com.mis.domain.NoticeFileVO;
import com.mis.domain.NoticeVO;
import com.mis.domain.SearchCriteria;

public interface NoticeDAO {

	// 1. 관리자 :: Notice 등록
	public int adCreate(NoticeVO vo) throws Exception;

	// 2. 관리자 :: Notice 상세보기
	// 학생 :: Notice 상세보기
	public NoticeVO read(int noticeNo) throws Exception;

	// 3. 관리자 :: Notice 수정
	public void adUpdate(NoticeVO vo) throws Exception;

	// 4. 관리자 :: Notice 삭제
	public void adDelete(int noticeNo) throws Exception;

	// 5. 관리자 :: Notice 검색 가능한 목록
	// 학생 :: Notice 검색 가능한 목록
	public List<NoticeVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	// 6. 관리자 :: Notice 검색 가능한 목록 ---> 페이징 , 카운트
	// 학생 :: Notice 검색 가능한 목록 ---> 페이징 , 카운트
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception;

	// 7. 관리자 :: 파일 등록
	public void insertFile(NoticeFileVO fVo) throws Exception;

	// 8. 관리자 :: 파일 삭제
	public void deleteFile(int noticeNo) throws Exception;

	// 9. 관리자 :: 파일 목록
	public List<NoticeFileVO> fileList(int noticeNo) throws Exception;

}
