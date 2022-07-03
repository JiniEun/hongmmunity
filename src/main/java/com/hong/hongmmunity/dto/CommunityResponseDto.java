package com.hong.hongmmunity.dto;

import com.hong.hongmmunity.entity.Community;
import lombok.Getter;

@Getter
public class CommunityResponseDto {

    private int communityId;

    private String title;

    private String content;

    private String category;

    private String userEmail;

    private int viewCnt;

    public CommunityResponseDto(Community community) {
        this.communityId = community.getCommunityId();
        this.title = community.getTitle();
        this.content = community.getContent();
        this.category = community.getCategory();
        this.userEmail = community.getUser().getUserEmail();
        this.viewCnt = community.getViewCnt();
    }
}
