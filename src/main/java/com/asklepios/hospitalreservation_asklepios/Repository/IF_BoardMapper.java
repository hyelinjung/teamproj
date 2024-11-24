package com.asklepios.hospitalreservation_asklepios.Repository;

import com.asklepios.hospitalreservation_asklepios.VO.BoardVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IF_BoardMapper {
    public void insertOne(BoardVO boardVO);
}
