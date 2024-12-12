package com.asklepios.hospitalreservation_asklepios.Util;

import com.asklepios.hospitalreservation_asklepios.Interceptor.BoardInterceptor;
import com.asklepios.hospitalreservation_asklepios.Interceptor.RegistrationInterceptor;
import com.asklepios.hospitalreservation_asklepios.Interceptor.ReservationFormInterceptor;
import com.asklepios.hospitalreservation_asklepios.Interceptor.ReservationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Autowired
  private ReservationInterceptor reservationinterceptor;

  @Autowired
  private RegistrationInterceptor registrationinterceptor;

  @Autowired
  private ReservationFormInterceptor reservationforminterceptor;

  @Autowired
  private BoardInterceptor boardinterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(reservationinterceptor).addPathPatterns("/reservation","/reserve");
    registry.addInterceptor(registrationinterceptor).addPathPatterns("/registration");
    registry.addInterceptor(boardinterceptor).addPathPatterns("/write");
    registry.addInterceptor(reservationforminterceptor).addPathPatterns("/reservationForm");
  }

}
