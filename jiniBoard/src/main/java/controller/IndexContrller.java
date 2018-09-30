package controller;

import domain.Board;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BoardService;

import java.util.List;

@Controller
public class IndexContrller {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public String doA(Model model) {
        List<Board> boardList = boardService.getBoards();
        model.addAttribute(boardList);
        return "hello";
    }
}