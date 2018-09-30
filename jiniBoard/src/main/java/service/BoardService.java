package service;

import domain.Board;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    public void addBoard(Board board);

    List<Board> getBoards();

    Board getBoard(int id);

    void delete(int id);

    void update(Board board);
}
