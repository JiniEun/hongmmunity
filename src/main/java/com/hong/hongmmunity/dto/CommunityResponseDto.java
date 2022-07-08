package com.hong.hongmmunity.dto;

import com.hong.hongmmunity.entity.Community;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommunityResponseDto {

    private Long communityId;

    private String title;

    private String content;

    private String category;

    private String userEmail;

    private String userName;

    private int viewCnt;

    private LocalDateTime modifiedDate;

    public CommunityResponseDto(Community community) {
        this.communityId = community.getCommunityId();
        this.title = community.getTitle();
        this.content = community.getContent();
        this.category = community.getCategory();
        this.userEmail = community.getUser().getUserEmail();
        this.userName = community.getUser().getUserName();
        this.viewCnt = community.getViewCnt();
        this.modifiedDate = community.getModifiedDate();
    }
}
