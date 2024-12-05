package com.asklepios.hospitalreservation_asklepios.Service;

import com.asklepios.hospitalreservation_asklepios.VO.ReservationVO;

public interface IF_ReservationService {
  public boolean checkHospitalName(String hospitalName);
  public String findHospitalAddress(String hospitalName);
  public String findHospitalCode(String hospitalName);
  public String findDoctorName(String doctorCode);
  public String[] findAllReservationTime(String hospitalName, String doctorName, String reservationDate);
  public void addReservation(String hospitalName, String doctorName, String userName, String reservationDate, String reservationTime, String reservationMemo);
  public void addReservation(ReservationVO reservationvo);
}

