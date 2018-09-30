package dao;

import domain.Board;
import jdk.nashorn.internal.objects.annotations.Setter;
import mapper.BoardMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void addBoard(Board board) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoardMapper mapper = sqlSession.getMapper(mapper.BoardMapper.class);
        mapper.insert(board);
    }

    public List<Board> getBoards() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoardMapper mapper = sqlSession.getMapper(mapper.BoardMapper.class);
        return mapper.selectAll();
    }

    public Board getBoard(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoardMapper mapper = sqlSession.getMapper(mapper.BoardMapper.class);
        return mapper.selectOne(id);
    }

    public void delete(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoardMapper mapper = sqlSession.getMapper(mapper.BoardMapper.class);
        mapper.delete(id);
    }

    public void update(Board board) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoardMapper mapper = sqlSession.getMapper(mapper.BoardMapper.class);
        mapper.update(board);
    }
}
