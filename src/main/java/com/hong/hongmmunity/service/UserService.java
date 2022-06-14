package com.hong.hongmmunity.service;

import com.hong.hongmmunity.dto.UserResponseDto;
import com.hong.hongmmunity.dto.UserSignupRequestDto;
import com.hong.hongmmunity.dto.UserUpdateRequestDto;
import com.hong.hongmmunity.entity.User;
import com.hong.hongmmunity.exception.BaseException;
import com.hong.hongmmunity.exception.BaseResponseCode;
import com.hong.hongmmunity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean existsByUserEmail(String email) {
        return userRepository.existsByUserEmail(email).orElseThrow(() -> new BaseException(BaseResponseCode.BAD_REQUEST));
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new BaseException(BaseResponseCode.NOT_FOUND));
        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserByEmail(String email) {
        User user = userRepository.findByUserEmail(email).orElseThrow(() -> new BaseException(BaseResponseCode.NOT_FOUND));
        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    public Long create(UserSignupRequestDto userSignupRequestDto) {

        boolean exitsCheck = userRepository.existsByUserEmail(userSignupRequestDto.getUserEmail()).orElseThrow(() -> new BaseException(BaseResponseCode.BAD_REQUEST));

        if (exitsCheck) {
            throw new BaseException(BaseResponseCode.DUPLICATE_EMAIL);
        }
        Long id;
        try {
            id = userRepository.save(userSignupRequestDto.toEntity()).getUserId();
        } catch (Exception e) {
            throw new BaseException(BaseResponseCode.FAILED_TO_SAVE_USER);
        }

        return id;
    }

    public Optional<User> update(UserUpdateRequestDto userUpdateRequestDto) throws BaseException {
        Optional<User> user = userRepository.findById(userUpdateRequestDto.getUserId());
        try{
            user.ifPresent(selectUser -> {
                selectUser.setUserPhoneNumber(userUpdateRequestDto.getUserPhoneNumber());
                userRepository.save(selectUser);
            });
        } catch(Exception e){
            throw new BaseException(BaseResponseCode.METHOD_NOT_ALLOWED);
        }
        return user;
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
