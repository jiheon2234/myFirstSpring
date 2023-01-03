package com.mis.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mis.domain.QnAVO;
import com.mis.domain.SearchCriteria;
import com.mis.persistence.QnADAO;
import com.mis.persistence.ReplyDAO;

@Service
public class QnAServiceImpl implements QnAService {

	@Inject
	private QnADAO dao;

	@Inject
	private ReplyDAO replyDao;

	@Override
	public void register(QnAVO vo) throws Exception {

		// 1) TextArea 줄바꿈 적용
		vo.setQnaContents(vo.getQnaContents().replace("\\r\\n", "<br>"));

		// 2) 문의글 저장
		dao.create(vo);

	}

	@Override
	public QnAVO read(int qnaNo) throws Exception {
		// 1) 조회수 update
		dao.updateHits(qnaNo);
		// 2)문의글 가져오기
		return dao.read(qnaNo);
	}

	@Override
	public void modify(QnAVO vo) throws Exception {
		// 1) TextArea 줄바꿈 적용
		vo.setQnaContents(vo.getQnaContents().replace("\\r\\n", "<br>"));

		// 2) 문의글 수정
		dao.update(vo);

	}

	@Override
	public void remove(int qnaNo) throws Exception {
		// 1) 자식 댓글 삭제
		replyDao.deleteAll(qnaNo);

		// 2) 문의 글 삭제
		dao.delete(qnaNo);

	}

	@Override
	public List<QnAVO> listSearch(SearchCriteria cri) throws Exception {
		return dao.listSearchCriteria(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCountCriteria(cri);
	}

}
