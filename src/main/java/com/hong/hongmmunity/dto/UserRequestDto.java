package com.hong.hongmmunity.dto;

import com.hong.hongmmunity.entity.User;
import lombok.Builder;

public class UserRequestDto {
    private String userEmail;

    @Builder
    public UserRequestDto(String userEmail){
        this.userEmail = userEmail;
    }

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .build();
    }


}
