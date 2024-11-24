package com.asklepios.hospitalreservation_asklepios.Service;

import com.asklepios.hospitalreservation_asklepios.VO.BoardVO;
import com.asklepios.hospitalreservation_asklepios.Repository.IF_BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IM_BoardService implements IF_BoardService{
    @Autowired
    IF_BoardMapper boardMapper;

    @Override
    public void addBoard(BoardVO boardVO) {
        System.out.println(boardVO.toString());
        boardMapper.insertOne(boardVO);
    }
}
