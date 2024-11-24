package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.Service.IF_BoardService;
import com.asklepios.hospitalreservation_asklepios.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    IF_BoardService boardService;

    @GetMapping("/home")
    public String main(){
        return "home";
    }
    @GetMapping("/board")
    public String board(){
        return "board/main";
    }
    @GetMapping("board/write")
    public String write(){
        return "board/write";
    }
    @PostMapping("/board/submitwrite")
    public String submitWrite(@ModelAttribute BoardVO boardVO){
        boardService.addBoard(boardVO);
        System.out.println(boardVO.toString());
        return "redirect:/board";
    }

}
