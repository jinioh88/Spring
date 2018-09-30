package service;

import dao.BoardDAO;
import domain.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardDAO boardDAO;

    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public void addBoard(Board board) {
        boardDAO.addBoard(board);
    }

    @Override
    public List<Board> getBoards() {
        return boardDAO.getBoards();
    }

    @Override
    public Board getBoard(int id) {
        return boardDAO.getBoard(id);
    }

    @Override
    public void delete(int id) {
        boardDAO.delete(id);
    }

    @Override
    public void update(Board board) {
        boardDAO.update(board);
    }
}
