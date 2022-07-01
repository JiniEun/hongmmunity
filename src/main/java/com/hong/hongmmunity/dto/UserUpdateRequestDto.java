package com.hong.hongmmunity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String userEmail;
    private String userPhoneNumber;

    @Builder
    public UserUpdateRequestDto(String userEmail, String userPhoneNumber) {
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }
}
