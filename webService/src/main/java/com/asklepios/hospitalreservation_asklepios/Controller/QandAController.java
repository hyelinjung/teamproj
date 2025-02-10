package com.asklepios.hospitalreservation_asklepios.Controller;

import org.springframework.ui.Model;
import com.asklepios.hospitalreservation_asklepios.Service.IF_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class QandAController {
  @Autowired
  IF_UserService userservice;

  @GetMapping("/qanda")
  public String qna(Model model) {
    model.addAttribute("user",  userservice.findMember());
    return "qanda/questionForm";
  }


}
