package com.asklepios.hospitalreservation_asklepios.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ReservationInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    Object user = session.getAttribute("loginUser");
    System.out.println(user);
      response.setContentType("text/html; charset=UTF-8");
      response.setCharacterEncoding("UTF-8");
    if(user == null) {
      response.getWriter().println("<script>alert('로그인이 필요합니다. 로그인 페이지로 이동합니다.'); location.href='/asklepios/login';</script>");
      response.getWriter().flush();
      return false;
    }
    return true;
  }
}
