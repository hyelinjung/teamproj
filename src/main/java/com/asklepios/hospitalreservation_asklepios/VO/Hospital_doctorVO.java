package com.asklepios.hospitalreservation_asklepios.VO;

import lombok.Data;

@Data
public class Hospital_doctorVO {
  private String hospital_code;
  private String hospital_name;
  private String hospital_intro;
  private String hospital_notice;
  private String hospital_time;
  private String hospital_date;
  private String hospital_tel;
  private String hospital_addr;
  private String doctor_code;
  private String user_doctor_id;
  private String user_doctor_hospital_code;
  private String user_doctor_medical;
  private String user_doctor_career;
  private String user_doctor_graduate;
  private String user_name;
  private String user_image;
  private String login_name;
}
