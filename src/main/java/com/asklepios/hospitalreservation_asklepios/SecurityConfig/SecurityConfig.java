package com.asklepios.hospitalreservation_asklepios.SecurityConfig;

import jakarta.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {
  @Autowired
  MyUserDetailService myUserDetailService;


  @Bean
  AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }



  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf((csrfConfig) -> csrfConfig.disable())
        .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests

            .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
            .requestMatchers("/", "/home", "/reservation", "Img/**", "CSS/**", "JS/**", "profile_image/**","/login","/popularHospital").permitAll() // 요청은 허용
            .requestMatchers("/registration").hasRole("doctor")
            .requestMatchers("/reservation").hasAnyRole("doctor","client")
            .anyRequest().authenticated())

        .formLogin((formLogin) ->
                formLogin
                    .loginPage("/login")  //로그인 페이지
                    .defaultSuccessUrl("/")   //로그인 성공시
                    .loginProcessingUrl("/loginProc")
                    .usernameParameter("user_id")   // 입력한 ID
                    .passwordParameter("user_password")   //입력한 PW
                    .failureUrl("/login")   //로그인 실패시
        )

        .logout((logout)->logout
                  .logoutSuccessUrl("/")  //로그아웃
                  .logoutUrl("/logout")
                  .invalidateHttpSession(true)   //전체 세션 삭제
        );
    return http.build();
  }
//  @Override
//  public void configure(WebSecurity web) throws Exception{
//    web.ignoring().antMatchers("/static/JS/**","/static/CSS/**","/static/Img/**", "/static/profile_image/**","/static/ExcelTemplate/**");
//  }
//  @Override
//  public void configure(AuthenticationManagerBuilder auth) throws Exception{
//    auth.userDetailsService(myUserDetailService);
//  }
}
