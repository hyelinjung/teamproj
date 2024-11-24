package com.asklepios.hospitalreservation_asklepios.Service;




import com.asklepios.hospitalreservation_asklepios.Repository.IF_BoardMapper;
import com.asklepios.hospitalreservation_asklepios.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IM_BoardService implements IF_BoardService{
    @Autowired
    IF_BoardMapper boardMapper;

    @Override
    public void addBoard(BoardVO boardVO) {

        String category=boardVO.getBoard_category();
        if(category!=null){
            if(category.equals("1")){
                boardVO.setBoard_category("오늘의 건강");
            } else if (category.equals("2")) {
                boardVO.setBoard_category("캠페인");
            }else if (category.equals("3")) {
                boardVO.setBoard_category("의료기기");
            }else if (category.equals("4")) {
                boardVO.setBoard_category("자유게시판");
            }
        }
//        System.out.println(boardVO.toString());
        boardMapper.insertOne(boardVO);
    }

    @Override
    public List<BoardVO> boardList() {
        return boardMapper.selectAll();
    }


}
