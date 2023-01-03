package com.mis.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.NoticeFileVO;
import com.mis.domain.NoticeVO;
import com.mis.domain.SearchCriteria;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Inject
	private SqlSession session;

	private static final String namespace = "com.mis.mapper.NoticeMapper";
	

	@Override
	public int adCreate(NoticeVO vo) throws Exception {
		session.insert(namespace + ".adCreate", vo);
		return vo.getNoticeNo();
	}

	@Override
	public NoticeVO read(int noticeNo) throws Exception {
		return session.selectOne(namespace + ".read", noticeNo);
	}

	@Override
	public void adUpdate(NoticeVO vo) throws Exception {
		session.update(namespace + ".adUpdate", vo);

	}

	@Override
	public void adDelete(int noticeNo) throws Exception {
		session.delete(namespace + ".adDelete", noticeNo);
	}

	@Override
	public List<NoticeVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearchCriteria", cri);
	}

	@Override
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCountCriteria", cri);
	}

	@Override
	public void insertFile(NoticeFileVO fVo) throws Exception {
		session.insert(namespace + ".insertFile", fVo);

	}

	@Override
	public void deleteFile(int noticeNo) throws Exception {
		session.delete(namespace + ".deleteFile", noticeNo);
	}

	@Override
	public List<NoticeFileVO> fileList(int noticeNo) throws Exception {
		return session.selectList(namespace + ".fileList", noticeNo);
	}

}
