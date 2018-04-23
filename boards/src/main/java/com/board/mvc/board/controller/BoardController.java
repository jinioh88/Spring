package com.board.mvc.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.board.mvc.board.domain.BoardVO;
import com.board.mvc.board.service.BoardService;

@Controller
@SessionAttributes("boardVO")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/list")
	@ResponseBody
	public String list(Model model) {
		model.addAttribute("boardList",boardService.list());
		return "/board/list";
	}
	
	@RequestMapping(value="/board/read/{seq}")
	public String read(Model model,@PathVariable int seq) {
		model.addAttribute("boardVO",boardService.read(seq));
		return "/board/read";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO",new BoardVO());
		return "/board/write";
	}
	
	@RequestMapping(value="/board/writer", method=RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindngResult, SessionStatus sessionStatus) {
		if(bindngResult.hasErrors()) {
			return "/board/write";
		} else {
			boardService.write(boardVO);
			sessionStatus.setComplete(); // �ڵ� ��ϵ� ���� ����. 
			return "readirect:/board/list";	
		}
	}
	
	@RequestMapping(value="/board/edit/{seq}", method = RequestMethod.GET)
	public String edit(@ModelAttribute BoardVO boardVO) {
	
		return "/board/edit";
	}
	
	@RequestMapping(value="/board/edit", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute BoardVO boardVO,BindingResult result, SessionStatus sessionStatus,int pwd, 
							Model model) {
		if(result.hasErrors()) {
			return "/board/edit";
		} else {
			if(boardVO.getPassword()==pwd) {
				boardService.edit(boardVO);
				sessionStatus.setComplete(); // ���ǰ�ü ����
				return "redirect:/board/list";
			}
		}
		 
		model.addAttribute("msg","��й�ȣ ��ġ ���� ����");
		return "/board/edit";
	}
	
	@RequestMapping(value="/board/delete/{seq}", method = RequestMethod.GET)
	public String delete(@PathVariable int seq, Model model) {
		model.addAttribute("seq",seq);
		return "/board/delete";
	}
	
	@RequestMapping(value="/board/delete", method = RequestMethod.POST)
	public String delete(int seq, int pwd, Model model) {
		int rowCount;
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(seq);
		boardVO.setPassword(pwd);
		
		rowCount = boardService.delete(boardVO);
		
		if(rowCount==0) {
			model.addAttribute("seq",seq);
			model.addAttribute("msg","��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return "/board/delete";
		} else {
			return "/board/delete";	
		}
	}
	
	
}
