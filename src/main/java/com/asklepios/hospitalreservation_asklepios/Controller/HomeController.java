package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.Service.IF_BoardService;
import com.asklepios.hospitalreservation_asklepios.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    IF_BoardService boardService;
    @GetMapping("/home")
    public String main(){
        return "home";
    }
    @GetMapping("/bboard")
    public String board(Model model ){
        List<BoardVO> boardlist=boardService.boardList();
        model.addAttribute("boardlist",boardlist);
        return "board/main";
    }
    @GetMapping("bboard/write")
    public String write(){
        return "board/write";
    }
    @PostMapping("/bboard/submitwrite")
    public String submitWrite(@ModelAttribute BoardVO boardVO){
        boardService.addBoard(boardVO);
//        System.out.println(boardVO.toString());
        return "redirect:/bboard";
    }

}
