package com.mis.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.BoardVO;
import com.mis.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	@Test
	public void createTest() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setBno(0);
		vo.setTitle("테스트입니다");
		vo.setContent("TEST CONTENT");
		vo.setWriter("jiheon");
		
		dao.create(vo);
	}
	@Test
	public void readTest() throws Exception{
		
		BoardVO vo = dao.read(1);
		System.out.println(vo);
	}
	
	@Test
	public void listAllTest() throws Exception{
		List<BoardVO> list = dao.listAll();
		
		for (BoardVO vo:list) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void updateTest() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("수정하는 타이틀");
		vo.setContent("수정하는 내용");
		vo.setWriter("수정");
		dao.update(vo);
	}
	
	@Test
	public void deleteTest() throws Exception{
		dao.delete(2);
	}
}
