package org.zero.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zero.domain.MemberVO;
import org.zero.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime()throws Exception {
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testInsertMember()throws Exception{
		MemberVO vo = new MemberVO();
		vo.setUserid("user01");
		vo.setUserpw("1111");
		vo.setUsername("Hong gildong");
		vo.setEmail("gildong@gmail.com");
		
		dao.insertMember(vo);
	}
}
