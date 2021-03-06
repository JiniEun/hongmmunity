package com.hong.hongmmunity.dto;

import com.hong.hongmmunity.entity.User;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class UserResponseDto {

    private final String userEmail;

    private final String userPassword;

    private final String userName;

    private final String userGender;

    private final String userStudentId;

    private final String userPhoneNumber;

    private final String userGrade;

    public UserResponseDto(User user) {
        this.userEmail = user.getUserEmail();
        this.userPassword = user.getUserPassword();
        this.userName = user.getUserName();
        this.userGender = user.getUserGender();
        this.userStudentId = user.getUserStudentId();
        this.userPhoneNumber = user.getUserPhoneNumber();
        this.userGrade = user.getUserGrade();
    }
}
