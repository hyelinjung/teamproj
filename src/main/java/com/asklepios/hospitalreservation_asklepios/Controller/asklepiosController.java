package com.asklepios.hospitalreservation_asklepios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class asklepiosController {

    @GetMapping("/")
    public String home() {
        return "call";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}