package com.hong.hongmmunity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hong.hongmmunity.utility.Crawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model, HttpSession session, HttpServletRequest request) throws Exception{


        String location = "경기도";
        // 코로나 정보 불러오기
        List<String> covidResult = Crawler.covidCrawling(location);


        model.addAttribute("covid", covidResult);


        return "/";
    }

//    @GetMapping("/test")
//    public String test() {
//
//        return "test";
//    }
}
