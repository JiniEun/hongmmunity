package com.hong.hongmmunity.dto;

import com.hong.hongmmunity.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSignupRequestDto {
    private String userEmail;

    private String userPassword;

    private String userName;

    private String userGender;

    private String userStudentId;

    private String userGrade;

    @Builder
    public UserSignupRequestDto(String userEmail, String userPassword, String userName, String userGender, String userStudentId, String userGrade) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userGender = userGender;
        this.userStudentId = userStudentId;
        this.userGrade = userGrade;
    }

    public User toEntity() {
        return User.builder()
                .userEmail(userEmail)
                .userPassword(userPassword)
                .userName(userName)
                .userGender(userGender)
                .userStudentId(userStudentId)
                .userGrade(userGrade)
                .build();
    }
}
