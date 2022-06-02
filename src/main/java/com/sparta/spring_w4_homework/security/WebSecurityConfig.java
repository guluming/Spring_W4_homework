package com.sparta.spring_w4_homework.security;

import com.sparta.spring_w4_homework.security.filter.JwtAuthenticationFilter;
import com.sparta.spring_w4_homework.security.provider.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    public WebSecurityConfig(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // 정적인 파일에 대한 요청들
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/file/**",
            "/image/**",
            "/swagger/**",
            "/swagger-ui/**",
            // other public endpoints of your API may be appended to this array
            "/h2/**",
            "/h2-console/**"
    };

    @Bean
    public BCryptPasswordEncoder encodePassword() {  // 회원가입 시 비밀번호 암호화에 사용할 Encoder 빈 등록
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests();

        http.authorizeRequests()
                // login 없이 접근 허용 하는 url
                .antMatchers("/").permitAll()
                .antMatchers("/index/").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/boards/list/**").permitAll()
                .antMatchers("/replys/list").permitAll()
                // '/admin'의 경우 ADMIN 권한이 있는 사용자만 접근이 가능
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/dashboard").hasRole("USER")
//                .antMatchers("/dashboard").permitAll()
                // 그 외 모든 요청은 인증과정 필요
                .anyRequest().authenticated()
                .and()
                // 토큰 기반 인증이기 때문에 session 사용 x
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                // JwtAuthenticationFilter 는 UsernamePasswordAuthenticationFilter 전에 넣음
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CustomeBasicAuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomeBasicAuthenticationEntryPoint();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 정적인 파일 요청에 대해 무시
        web.ignoring().antMatchers(AUTH_WHITELIST);
    }
}