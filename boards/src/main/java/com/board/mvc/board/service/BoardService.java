package com.board.mvc.board.service;

import java.util.List;

import com.board.mvc.board.domain.BoardVO;

public interface BoardService {
	public abstract List<BoardVO> list();
	public abstract int delete(BoardVO boardVO);
	public abstract int edit(BoardVO boardVo);
	public abstract void write(BoardVO boardVO);
	public abstract BoardVO read(int seq);
}
