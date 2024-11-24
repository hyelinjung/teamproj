package com.asklepios.hospitalreservation_asklepios.Service;

import com.asklepios.hospitalreservation_asklepios.VO.BoardVO;

import java.util.List;

public interface IF_BoardService {
    public void addBoard(BoardVO boardVO);
    public List<BoardVO> boardList();
}
