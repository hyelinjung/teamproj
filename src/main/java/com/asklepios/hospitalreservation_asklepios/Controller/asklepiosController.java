package com.asklepios.hospitalreservation_asklepios.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class asklepiosController {

    @GetMapping("/")
    public String home() {
        return "call";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
}
