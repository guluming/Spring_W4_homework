package com.sparta.spring_w4_homework.service;

import com.sparta.spring_w4_homework.model.User;
import com.sparta.spring_w4_homework.repository.UserRepository;
import com.sparta.spring_w4_homework.requestdto.UserRequestDto;
import com.sparta.spring_w4_homework.security.provider.JwtTokenProvider;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    UserRepository userRepository;
    @Mock
    AuthenticationManager authenticationManager;
    @Mock
    JwtTokenProvider jwtTokenProvider;

    @Test
    @DisplayName("정상 케이스")
    void signup_Normal() {
        //given
        String username = "mbstest1";
        String password = "123456789";
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("회원가입이 완료 되었습니다.", result);

    }

    @Test
    @DisplayName("실패케이스 - ID - null")
    void IdFail1() {
        //given
        String username = null;
        String password = "123456789";
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("ID를 입력해 주세요.", result);
    }

    @Test
    @DisplayName("실패케이스 - ID - 빈문자열")
    void IdFail2() {
        //given
        String username = "";
        String password = "123456789";
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("ID를 입력해 주세요.", result);
    }

    @Test
    @DisplayName("실패케이스 - ID - 형식 위반")
    void IdFail3() {
        //given
        String username = "bs";
        String password = "123456789";
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("ID 형식을 확인해 주세요.", result);
    }

    @Test
    @DisplayName("실패케이스 - ID - 중복")
    void IdFail4() {
        //given
        String username = "mbs123";
        String password = "123456789";
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        User user = new User(testUserDto);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);
        when(userRepository.findByUsername(username))
                .thenReturn(Optional.of(user));

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("중복된 닉네임 입니다.", result);
    }

    @Test
    @DisplayName("실패케이스 - PASSWORD - null")
    void PasswordFail1() {
        //given
        String username = "mbs123";
        String password = null;
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("비밀번호를 입력해 주세요.", result);
    }

    @Test
    @DisplayName("실패케이스 - PASSWORD - 빈문자열")
    void PasswordFail2() {
        //given
        String username = "mbs123";
        String password = "";
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("비밀번호를 입력해 주세요.", result);
    }

    @Test
    @DisplayName("실패케이스 - PASSWORD - 형식 위반")
    void PasswordFail3() {
        //given
        String username = "mbs123";
        String password = "12";
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("비밀번호 형식을 확인해 주세요.", result);
    }

    @Test
    @DisplayName("실패케이스 - PASSWORD - 재확인 짧음")
    void PasswordFail4() {
        //given
        String username = "mbs123";
        String password = "123456789123";
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("비밀번호 재확인이 다릅니다.", result);
    }

    @Test
    @DisplayName("실패케이스 - PASSWORD - 재확인 김")
    void PasswordFail5() {
        //given
        String username = "mbs123";
        String password = "123456";
        String passwordchk = "123456789";

        UserRequestDto testUserDto = new UserRequestDto(username, password, passwordchk);

        UserService userService = new UserService(passwordEncoder, userRepository, authenticationManager, jwtTokenProvider);

        //when
        String result = userService.signup(testUserDto);

        //then
        assertEquals("비밀번호 재확인이 다릅니다.", result);
    }

}

