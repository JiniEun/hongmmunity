package com.hong.hongmmunity.controller;

import com.hong.hongmmunity.dto.UserSignupRequestDto;
import com.hong.hongmmunity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        /*----쿠키설정 내용시작----------------------------*/
        String c_id = ""; // ID 저장 여부를 저장하는 변수, Y
        String c_id_val = ""; // ID 값

        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];

                if (cookie.getName().equals("c_id")) {
                    c_id = cookie.getValue(); // Y
                } else if (cookie.getName().equals("c_id_val")) {
                    c_id_val = cookie.getValue(); // user1...
                }
            }
        }
        /*----쿠키설정 내용 끝----------------------------*/
        request.setAttribute("c_id", c_id);
        request.setAttribute("c_id_val", c_id_val);

        return "/user/login";
    }

    @GetMapping("/create")
    public String create(HttpServletRequest request) {
        return "/user/create";
    }

    @PostMapping("/create")
    public String create(UserSignupRequestDto dto, HttpServletRequest request) {

        if (userService.create(dto) > 0) {
            return "redirect:/";
        } else {
            return "error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";

    }
}
