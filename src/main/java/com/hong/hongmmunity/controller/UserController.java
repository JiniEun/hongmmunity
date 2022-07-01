package com.hong.hongmmunity.controller;

import com.hong.hongmmunity.dto.UserLoginRequestDto;
import com.hong.hongmmunity.dto.UserResponseDto;
import com.hong.hongmmunity.dto.UserSignupRequestDto;
import com.hong.hongmmunity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        log.info("GET : login()");
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

    // @RequestParam Map<String, String> map
    // @RequestParam UserLoginRequestDto userLoginRequestDto
    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> map, HttpSession session, HttpServletResponse response,
                        Model model) {
        //log.info("userLoginDto"+userLoginRequestDto.getUserEmail());
        log.info("POST : login()");
        log.info("map: " + map);

        boolean userCheck = userService.loginCheck(map);
        log.info("userCheck: "+userCheck);

        if (!userCheck) {
            model.addAttribute("msg", "아이디 또는 비밀번호를 잘못 입력 했거나 <br>회원이 아닙니다. 회원가입 하세요");
            return "/user/errorMsg";
        }

        UserResponseDto userResponseDto = userService.findUserByMap(map);
        String grade = userService.getUserGrade(map);

        session.setAttribute("userEmail", userResponseDto.getUserEmail());
        session.setAttribute("grade", grade);

        // Cookie 저장, id 저장 여부 및 id
        Cookie cookie = null;
        String c_id = map.get("c_id");
        if (c_id != null) {
            cookie = new Cookie("c_id", c_id);
            cookie.setMaxAge(60 * 60 * 24 * 365);// 1년
            response.addCookie(cookie);

            cookie = new Cookie("c_id_val", map.get("ID"));
            cookie.setMaxAge(60 * 60 * 24 * 365);// 1년
            response.addCookie(cookie);
        } else {
            cookie = new Cookie("c_id", ""); // 쿠키 삭제
            cookie.setMaxAge(0);
            response.addCookie(cookie);

            cookie = new Cookie("c_id_val", "");// 쿠키 삭제
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        return "redirect:/";

    }

    @GetMapping("/signup")
    public String create(HttpServletRequest request) {
        log.info("GET : create");

        return "/user/create";
    }

    @PostMapping("/signup")
    public String create(@RequestParam Map<String, String> map, HttpServletRequest request) {

        log.info("POST : create");
        log.info("map: " + map);

        String userEmailCheck = userService.signUp(map);

        if (userEmailCheck != null && userEmailCheck != "") {
            return "redirect:/user/login";
        } else {
            return "error";
        }
    }

    @GetMapping(value = "/emailcheck", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String, String> emailCheck(String userEmail) {

        log.info("emailCheck");
        boolean emailCheck = userService.existsByUserEmail(userEmail);

        Map<String, String> map = new HashMap<>();
        if (emailCheck) {
            map.put("msg", userEmail + "는 중복되어서 사용할 수 없습니다.");

        } else {
            map.put("msg", userEmail + "는 중복아님, 사용가능 합니다.");
        }

        log.info(map.get("msg"));

        return map;

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";

    }
}
