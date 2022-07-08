package com.hong.hongmmunity.dto;

import com.hong.hongmmunity.entity.Community;
import com.hong.hongmmunity.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommunityCreateRequestDto {
    private User user;
    private String title;
    private String content;
    private String category;

    @Builder
    public CommunityCreateRequestDto(User user, String title, String content, String category){
        this.user = user;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Community toEntity(){
        return Community.builder()
                .user(user)
                .title(title)
                .content(content)
                .category(category)
                .build();
    }
}
