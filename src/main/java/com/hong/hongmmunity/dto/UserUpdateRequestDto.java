package com.hong.hongmmunity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private Long userId;
    private String userPhoneNumber;

    @Builder
    public UserUpdateRequestDto(Long userId, String userPhoneNumber) {
        this.userId = userId;
        this.userPhoneNumber = userPhoneNumber;
    }
}
