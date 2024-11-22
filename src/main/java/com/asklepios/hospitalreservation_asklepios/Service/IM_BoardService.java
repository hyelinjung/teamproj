package com.asklepios.hospitalreservation_asklepios.Service;

import com.asklepios.hospitalreservation.boardVO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IM_BoardService implements IF_BoardService{
    @Autowired
    com.asklepios.hospitalreservation.boardRepository.IF_BoardMapper boardRepository;

    @Override
    public void addBoard(BoardVO boardVO) {
//        System.out.println(boardVO.toString());
        boardRepository.insertBoard(boardVO);
    }
}
