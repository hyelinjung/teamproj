package com.asklepios.hospitalreservation_asklepios.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ReservationFormInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    Object user = session.getAttribute("loginUser");
    System.out.println(user);
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().println("<script>alert('병원예약을 통해 진행해주세요.'); location.href='/asklepios/reservation';</script>");
    response.getWriter().flush();
    return false;
  }
}
