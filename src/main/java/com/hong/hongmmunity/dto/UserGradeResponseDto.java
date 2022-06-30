package com.hong.hongmmunity.dto;

import lombok.Getter;

@Getter
public class UserGradeResponseDto {
    private final String userGrade;

    public UserGradeResponseDto(String userGrade) {
        this.userGrade = userGrade;
    }
}
