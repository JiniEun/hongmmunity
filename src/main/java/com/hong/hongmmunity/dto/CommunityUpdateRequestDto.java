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
public class CommunityUpdateRequestDto {
    private String title;
    private String content;
    private String category;

    @Builder
    public CommunityUpdateRequestDto(String title, String content, String category){
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Community toEntity(){
        return Community.builder()
                .title(title)
                .content(content)
                .category(category)
                .build();
    }
}
