package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.VO.UserVO;
import com.asklepios.hospitalreservation_asklepios.Service.IF_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    IF_UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserVO userVO,
                        @RequestParam("user_id") String id,
                        @RequestParam("user_password") String password) {
        userVO.setUser_id(id);
        userVO.setUser_password(password);
        System.out.println(id);
        System.out.println(password);
        userService.login(userVO);
        return "home";
    }
}
