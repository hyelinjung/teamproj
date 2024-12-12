package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.Service.IF_ReservationService;
import com.asklepios.hospitalreservation_asklepios.Service.IF_UserService;
import com.asklepios.hospitalreservation_asklepios.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AsklepiosController {
    @Autowired
    IF_UserService userservice;

    @Autowired
    IF_ReservationService reservationservice;

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
    @PostMapping("popularHospital")
    public String[] popularHospital(){
        return reservationservice.popularHospital();
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
    @GetMapping("reservationStatusDoctor")
    public String reservationStatusDoctor(@SessionAttribute(name = "loginUser", required = false) UserVO user, Model model) {
        model.addAttribute("user", user);
        return "myPage/reservationStatusDoctor";
    }
    @GetMapping("reservationStatusClient")
    public String reservationStatusClient(@SessionAttribute(name = "loginUser", required = false) UserVO user, Model model) {
        model.addAttribute("user", user);
        return "myPage/reservationStatusClient";
    }
}
