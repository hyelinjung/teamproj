package com.asklepios.hospitalreservation.boardRepository;

import com.asklepios.hospitalreservation.boardMapper.IF_BoardMapper;
import com.asklepios.hospitalreservation.boardVO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository_Imp implements IF_BoardRepository{
    @Autowired
    IF_BoardMapper boardMapper;
    @Override
    public void insertBoard(BoardVO boardVO) {
//        System.out.println(boardVO.toString());
        boardMapper.insertOne(boardVO);
    }
}
