
package com.mis.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.MemberVO;
import com.mis.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	
/*@Test
	public void testMemberInsert() throws Exception{
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		vo.setUsername("관리자");
		vo.setEmail("email@gmail.com");
	
		dao.insertMember(vo);
} */


@Test
public void testReadMember() throws Exception {
	MemberVO vo = dao.readMember("admin");
	System.out.println(vo);
}

@Test
public void testReadMemberWithPW() throws Exception {
	MemberVO vo = dao.readWithPW("admin", "1234");
	System.out.println(vo);
}

@Test
public void testGetTime() throws Exception{
	System.out.println("gettime=="+dao.getTime());
}

}