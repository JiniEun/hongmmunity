package com.hong.hongmmunity.service;

import com.hong.hongmmunity.controller.CommunityController;
import com.hong.hongmmunity.dto.*;
import com.hong.hongmmunity.entity.Community;
import com.hong.hongmmunity.entity.User;
import com.hong.hongmmunity.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private static final Logger log = LoggerFactory.getLogger(CommunityService.class);

    private final CommunityRepository communityRepository;
    private final UserService userService;

    private User getUser(String userEmail) {
        return userService.getUserByEmail(userEmail);
    }

    private Community getCommunityById(Long communityId) {
        return communityRepository.findByCommunityId(communityId);
    }

    public CommunityResponseDto findCommunityById(Long communityId) {
        return new CommunityResponseDto(communityRepository.findByCommunityId(communityId));
    }

    public List<CommunityResponseDto> readCommunityListByUser(Map<String, String> map) {
        String userEmail = map.get("userEmail");
        User user = getUser(userEmail);
        return findCommunityByUser(user);
    }

    public List<CommunityResponseDto> findCommunityByUser(User user) {
        return communityRepository.findCommunityByUser(user)
                .stream().map(CommunityResponseDto::new).collect(Collectors.toList());
    }


    public List<CommunityResponseDto> findAllCommunity() {

        return communityRepository.findAll()
                .stream().map(CommunityResponseDto::new).collect(Collectors.toList());
    }

    public int totalCommunity() {
        return findAllCommunity().size();
    }


    private CommunityCreateRequestDto getCommunityCreateRequestDtoByMap(Map<String, String> map) {
        String userEmail = map.get("userEmail");
        User user = getUser(userEmail);
        String title = map.get("title");
        String content = map.get("content");
        String category = map.get("category");

        log.info("getCommunityCreateRequestDtoByMap");
        log.info(map.toString());

        return new CommunityCreateRequestDto(user, title, content, category);
    }

    public Long registerCommunity(Map<String, String> map) {
        CommunityCreateRequestDto communityCreateRequestDto = getCommunityCreateRequestDtoByMap(map);
        return createCommunity(communityCreateRequestDto);
    }

    private Long createCommunity(CommunityCreateRequestDto communityCreateRequestDto) {
        return communityRepository.save(communityCreateRequestDto.toEntity()).getCommunityId();
    }

    public CommunityResponseDto updateCommunityById(Map<String, String> map) {
        Long communityId = Long.parseLong(map.get("communityId"));
        String title = map.get("title");
        String content = map.get("content");
        String category = map.get("category");
        CommunityUpdateRequestDto communityUpdateRequestDto = new CommunityUpdateRequestDto(title, content, category);
        return update(communityId, communityUpdateRequestDto);
    }

    public CommunityResponseDto update(Long communityId, CommunityUpdateRequestDto communityUpdateRequestDto) {
        Community community = getCommunityById(communityId);
        community.update(communityUpdateRequestDto.getTitle(), communityUpdateRequestDto.getContent(), communityUpdateRequestDto.getCategory());
        communityRepository.save(community);
        return new CommunityResponseDto(getCommunityById(communityId));
    }

    public boolean deleteById(Long communityId) {
        boolean deleteCheck = false;
        try {
            communityRepository.deleteById(communityId);
            deleteCheck = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteCheck;

    }

}
