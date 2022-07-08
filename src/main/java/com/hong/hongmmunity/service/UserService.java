package com.hong.hongmmunity.service;

import com.hong.hongmmunity.dto.*;
import com.hong.hongmmunity.entity.User;
import com.hong.hongmmunity.repository.UserRepository;
import com.hong.hongmmunity.utility.UserGrade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean existsByUserEmail(String email) {
        return userRepository.existsByUserEmail(email);
    }

    public boolean loginCheck(Map<String, String> map) {
        UserLoginRequestDto userLoginRequestDto = getUserLoginRequestDtoByMap(map);

        boolean userCheck = false;
        if (!existsByUserEmail(userLoginRequestDto.getUserEmail())) {
            return userCheck;
        }
        userCheck = findUserByEmail(userLoginRequestDto.getUserEmail()).getUserPassword().equals(userLoginRequestDto.getUserPassword());

        return userCheck;
    }

    private UserLoginRequestDto getUserLoginRequestDtoByMap(Map<String, String> map) {
        String userEmail = map.get("userEmail");
        String userPassword = map.get("userPassword");

        return new UserLoginRequestDto(userEmail, userPassword);
    }

    public String getUserGrade(Map<String, String> map) {
        String userEmail = map.get("userEmail");
        UserGradeResponseDto userGradeResponseDto = new UserGradeResponseDto(findUserByEmail(userEmail).getUserGrade());

        return userGradeResponseDto.getUserGrade();
    }

    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return  userRepository.findByUserEmail(email);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserByEmail(String email) {
        User user = userRepository.findByUserEmail(email);
        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserByMap(Map<String, String> map) {
        return findUserByEmail(map.get("userEmail"));
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    public String signUp(Map<String, String> map) {
//        map.get("userEmail")
        UserSignupRequestDto userSignupRequestDto = getUserSignupRequestDtoByMap(map);

        boolean emailCheck = existsByUserEmail(userSignupRequestDto.getUserEmail());

        if(emailCheck){
            return null;
        }

        return create(userSignupRequestDto);

    }

    private UserSignupRequestDto getUserSignupRequestDtoByMap(Map<String, String> map) {
        String userEmail = map.get("userEmail");
        String userPassword = map.get("userPassword");
        String userName = map.get("userName");
        String userGender = map.get("userGender");
        String userStudentId = map.get("userStudentId");


        return new UserSignupRequestDto(userEmail, userPassword, userName, userGender, userStudentId, UserGrade.MEMBER);
    }

//    public boolean duplicatedEmail(String userEmail){
//        return false;
//    }

    private String create(UserSignupRequestDto userSignupRequestDto) {
        return userRepository.save(userSignupRequestDto.toEntity()).getUserEmail();
    }

    public UserResponseDto update(UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findByUserEmail(userUpdateRequestDto.getUserEmail());

        user.setUserPhoneNumber(userUpdateRequestDto.getUserPhoneNumber());
        userRepository.save(user);

        return new UserResponseDto(user);
    }

    public String delete(String userEmail) {
        userRepository.deleteUserByUserEmail(userEmail);
        return userEmail;
    }
}
