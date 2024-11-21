package com.asklepios.hospitalreservation.boardService;

import com.asklepios.hospitalreservation.boardRepository.IF_BoardRepository;
import com.asklepios.hospitalreservation.boardVO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService_Imp implements IF_BoardService{
    @Autowired
    IF_BoardRepository boardRepository;

    @Override
    public void addBoard(BoardVO boardVO) {
//        System.out.println(boardVO.toString());
        boardRepository.insertBoard(boardVO);
    }
}
