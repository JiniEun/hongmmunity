package com.hong.hongmmunity.service;

import com.hong.hongmmunity.dto.CommunityResponseDto;
import com.hong.hongmmunity.entity.User;
import com.hong.hongmmunity.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepository communityRepository;


    public CommunityResponseDto findCommunityByUser(User user){
        return new CommunityResponseDto(communityRepository.findCommunityByUser(user));
    }

    public boolean deleteById(Long communityId){
        boolean deleteCheck = false;
        try {
            communityRepository.deleteById(communityId);
            deleteCheck = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return deleteCheck;

    }

}
