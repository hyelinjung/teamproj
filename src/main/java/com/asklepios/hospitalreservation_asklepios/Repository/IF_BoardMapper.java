package com.asklepios.hospitalreservation_asklepios.Repository;
import com.asklepios.hospitalreservation_asklepios.VO.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;


@Mapper
public interface IF_BoardMapper {
    public void insertOne(BoardVO boardVO);
    public List<BoardVO> selectAll();
}
