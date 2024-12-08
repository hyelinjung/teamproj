package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.Service.IF_RegistrationService;
import com.asklepios.hospitalreservation_asklepios.VO.HospitalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

  @Autowired
  IF_RegistrationService registrationservice;

  @GetMapping("/registration")
  public String registration() {
    return "registrationForm";
  }

  @ResponseBody
  @PostMapping("/duplicateHospital")
  public boolean duplicateHospital(@RequestParam("hospital_address") String hospitalAddress,
                                  @RequestParam("hospital_name") String hospitalName) {
    return registrationservice.duplicateCheck(hospitalAddress, hospitalName);
  }

  @PostMapping("/register")
  public String register(@ModelAttribute HospitalVO hospitalvo){
    registrationservice.registerHospital(hospitalvo);
    return "redirect:/home";
  }
}
