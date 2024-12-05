package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.Service.IF_ReservationService;
import com.asklepios.hospitalreservation_asklepios.VO.ReservationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservatioinController {
  @Autowired
  IF_ReservationService reservationService;

  @ResponseBody
  @PostMapping("/findHospitalName")
  public boolean findHospitalName(@RequestParam("hospital_name") String hospitalName) {
    return reservationService.checkHospitalName(hospitalName);
  }

  @PostMapping("/reserve")
  public String reserve(@RequestParam(value = "hospital_name", required = false) String hospitalName,Model model){
//    System.out.println(hospitalName);
    String doctorCode ="4fb63188-1578-4a0a-ae21-5a2786cb85cf";
    String doctorName = reservationService.findDoctorName(doctorCode);
    String hospitalCode = reservationService.findHospitalCode(hospitalName);
    model.addAttribute("hospital_name", hospitalName);
    model.addAttribute("hospital_code", hospitalCode);
    model.addAttribute("doctor_name", doctorName);
    model.addAttribute("doctor_code", doctorCode);
    model.addAttribute("user_name","조준곤");
    model.addAttribute("user_id","jojungon");
    model.addAttribute("user_tel","010-6880-3477");
    return "reservationForm";
  }

  @ResponseBody
  @PostMapping("/isReserve")
  public String[] reserve1(@RequestParam("reservation_date") String reservationDate,
                           @RequestParam("hospital_code") String hospitalCode,
                           @RequestParam("doctor_code") String doctorCode){
    System.out.println(hospitalCode);
    System.out.println(doctorCode
    );
    System.out.println(reservationDate);
    return reservationService.findAllReservationTime(hospitalCode, doctorCode, reservationDate);
  }

  @PostMapping("/reserve/submit")
  public String reservationSubmit(@ModelAttribute ReservationVO reservationvo){
//    System.out.println(reservationvo.toString());
    reservationService.addReservation(reservationvo);
    return "redirect:/home";
  }

  @GetMapping("/reservationForm")
  public String reservationForm() {
    return "reservationForm";
  }

}
