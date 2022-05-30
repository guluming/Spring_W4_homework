package com.sparta.spring_w4_homework.service;

import com.sparta.spring_w4_homework.model.User;
import com.sparta.spring_w4_homework.repository.UserRepository;
import com.sparta.spring_w4_homework.requestdto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
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
            User user = userRepository.save(params.toEntity());
            return response;
        }
    }

//    //회원로그인
//    public String userlogin(Long id, MemberRequestDto params){
//        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("아이디가 존재 하지 않습니다."));
//        if(!user.getPassword().equals(params.getPassword())){
//            return "비밀번호가 틀렸습니다.";
//        }
//        return "로그인에 성공했습니다.";
//    }
}
