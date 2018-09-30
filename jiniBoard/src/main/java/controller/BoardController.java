package controller;

import domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/registerform")
    public String registerForm() {
        return "board/registerForm";
    }

    @PostMapping("/register")
    public String register(String writer, String title, String content) {
        Board board = new Board().setWriter(writer).setTitle(title).setContent(content);
        boardService.addBoard(board);
        return "redirect:/";
    }

    @GetMapping("/read/{id}")
    public String read(@PathVariable("id") int id, Model model) {
        Board board = boardService.getBoard(id);
        model.addAttribute(board);
        return "board/read";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        boardService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/modifyform/{id}")
    public String modifyForm(@PathVariable("id") int id, Model model) {
        model.addAttribute(boardService.getBoard(id));
        return "/board/modify";
    }

    @PostMapping("modify/{id}")
    public String modify(@PathVariable("id") int id, Board board) {
        boardService.update(board.setId(id));
        return "redirect:/";
    }
}
