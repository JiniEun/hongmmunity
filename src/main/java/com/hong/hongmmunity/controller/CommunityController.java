package com.hong.hongmmunity.controller;

import com.hong.hongmmunity.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/community")
public class CommunityController {
    private static final Logger log = LoggerFactory.getLogger(CommunityController.class);

    private final CommunityService communityService;

}
