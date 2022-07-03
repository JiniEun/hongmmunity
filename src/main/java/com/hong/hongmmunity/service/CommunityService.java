package com.hong.hongmmunity.service;

import com.hong.hongmmunity.dto.CommunityResponseDto;
import com.hong.hongmmunity.entity.Community;
import com.hong.hongmmunity.entity.User;
import com.hong.hongmmunity.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepository communityRepository;


//    public CommunityResponseDto findCommunityByUser(Community community){
//        return new CommunityResponseDto(communityRepository.findCommunityByUser(community));
//    }

}
