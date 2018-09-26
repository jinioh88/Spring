package org.zerock.contrller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoTest {
	@Inject
	private BoardDAO dao;
	private static Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	
	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("���� ���");
		board.setContent("������ ��� �մϴ�.");
		board.setWriter("user00");
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception {
		System.out.println("========================");
		logger.info(dao.read(3).toString());
		System.out.println("========================");
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("������ ��");
		board.setContent("���� �׽�Ʈ");
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
	
	@Test
	public void testList() throws Exception {
		List<BoardVO> list = new ArrayList<>();
		list = dao.listAll();
		System.out.println(list.size());
	}
}
