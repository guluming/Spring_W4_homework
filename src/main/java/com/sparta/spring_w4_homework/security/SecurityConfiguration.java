//package com.sparta.spring_w4_homework.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, WebSecurity web) throws Exception {
//
//        web
//                    // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
//                    .ignoring()
//                    .antMatchers("/h2-console/**");
//
//        http.csrf()
//                    // 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시
//                    .ignoringAntMatchers("/user/**");
//
//        http.authorizeRequests()
//                    // image 폴더를 login 없이 허용
//                    .antMatchers("/images/**").permitAll()
//                    // css 폴더를 login 없이 허용
//                    .antMatchers("/css/**").permitAll()
//                    // 회원 관리 처리 API 전부를 login 없이 허용
//                    .antMatchers("/board/user/**").permitAll()
//                    // 어떤 요청이든 '인증'
//                    .anyRequest().authenticated()
//
//                .and()
//                    // 로그인 기능 허용
//                    .formLogin()
//                    .loginPage("/board/user/login")
//                    .defaultSuccessUrl("/")
//                    .failureUrl("/board/user/login?error")
//                    .permitAll()
//
//                .and()
//                    // 로그아웃 기능 허용
//                    .logout()
//                    .permitAll();
//
//        return http.build();
//    }
//}