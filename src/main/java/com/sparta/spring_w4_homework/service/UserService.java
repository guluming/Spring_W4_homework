package com.sparta.spring_w4_homework.service;

import com.sparta.spring_w4_homework.model.User;
import com.sparta.spring_w4_homework.repository.UserRepository;
import com.sparta.spring_w4_homework.requestdto.JwtRequestDto;
import com.sparta.spring_w4_homework.requestdto.UserRequestDto;
import com.sparta.spring_w4_homework.responsedto.JwtResponseDto;
import com.sparta.spring_w4_homework.security.UserDetailsImpl;
import com.sparta.spring_w4_homework.security.provider.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Map;
import java.util.Optional;

@Transactional
@Service
//@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //회원가입
    public String signup(UserRequestDto params){
        String response = "";
        String username = params.getUsername();
        String password = params.getPassword();
        String passwordchk = params.getPasswordchk();

        Optional<User> found = userRepository.findByUsername(username);
        if(username.equals("")){
            response = "ID를 입력해 주세요.";
            return response;
            //throw new IllegalArgumentException("ID를 입력해 주세요.");
        }
        else if(!username.matches("^[a-zA-Z0-9]{3,20}$")){
            response = "ID 형식을 확인해 주세요.";
            return response;
            //throw new IllegalArgumentException("ID 형식을 확인해 주세요.");
        }
        else if(found.isPresent()){
            response = "이미 존재하는 ID 입니다.";
            return response;
            //throw new IllegalArgumentException("이미 존재하는 ID 입니다.");
        }

        if(password.equals("")){
            response = "비밀번호를 입력해 주세요.";
            return response;
            //throw new IllegalArgumentException("비밀번호를 입력해 주세요.");
        }
        else if(password.contains(params.getUsername()) || params.getUsername().contains(password) || !password.matches("^[a-zA-Z0-9]{4,20}$")){
            response = "비밀번호 형식을 확인해 주세요.";
            return response;
            //throw new IllegalArgumentException("비밀번호 형식을 확인해 주세요.");
        }
        else if(!password.equals(passwordchk)){
            response = "비밀번호 재확인이 다릅니다.";
            return response;
            //throw new IllegalArgumentException("비밀번호 재확인이 다릅니다.");
        }else{
            response = "회원가입이 완료 되었습니다.";

            User user = new User(params);
            user.encryptPassword(passwordEncoder);

            userRepository.save(user);
            return response;
        }
    }

    //회원로그인
    public JwtResponseDto login(JwtRequestDto params) throws Exception {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(params.getUsername(), params.getPassword()));
            return createJwtToken(authentication);
    }

    //JWT 토큰 생성기
    private JwtResponseDto createJwtToken(Authentication authentication) {
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(principal);
        return new JwtResponseDto(token);
    }
}
