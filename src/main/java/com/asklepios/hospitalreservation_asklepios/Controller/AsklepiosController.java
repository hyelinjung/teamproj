package com.asklepios.hospitalreservation_asklepios.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsklepiosController {

    @GetMapping("/")
    public String home() {
        return "call";
    }
}