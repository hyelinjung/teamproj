package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.Service.IF_UserService;
import com.asklepios.hospitalreservation_asklepios.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AsklepiosController {
    @Autowired
    IF_UserService userservice;

    @GetMapping("/")
    public String home() {
        return "redirect:home";
    }

    @GetMapping("/home")
    public String main(@SessionAttribute(name = "loginUser", required = false) UserVO user, Model model){
        model.addAttribute("user", user);
        return "home";
    }

    @ResponseBody
    @PostMapping("findDoctorCode")
    public String findDoctorCode(@RequestParam("user_id") String userId) {
//        System.out.println(userservice.findDoctorCode(userId));
        return userservice.findDoctorCode(userId);
    }

    @ResponseBody
    @PostMapping("reservationCount")
    public int reservationCount(@RequestParam("doctor_code") String doctorCode) {
//        System.out.println(userservice.countReservation(doctorCode));
        return userservice.countReservation(doctorCode);
    }

    @ResponseBody
    @PostMapping("totalReservationCount")
    public int totalReservationCount(@RequestParam("user_id") String userId) {
//        System.out.println(userservice.countTotalReservation(userId));
        return userservice.countTotalReservation(userId);
    }

}
