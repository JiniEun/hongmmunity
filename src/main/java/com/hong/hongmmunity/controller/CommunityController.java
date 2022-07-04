package com.hong.hongmmunity.controller;

import com.hong.hongmmunity.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/community")
public class CommunityController {
    private static final Logger log = LoggerFactory.getLogger(CommunityController.class);

    private final CommunityService communityService;


    @PostMapping("/delete")
    public String delete(Long communityId) {

        boolean deleteCheck = communityService.deleteById(communityId);

        if (deleteCheck) {
            return "redirect:/community/list";
        } else {
            return "error";
        }

    }

}
