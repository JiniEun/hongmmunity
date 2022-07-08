package com.hong.hongmmunity.controller;

import com.hong.hongmmunity.dto.CommunityCreateRequestDto;
import com.hong.hongmmunity.dto.CommunityResponseDto;
import com.hong.hongmmunity.dto.UserResponseDto;
import com.hong.hongmmunity.service.CommunityService;
import com.hong.hongmmunity.service.UserService;
import com.hong.hongmmunity.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@RequestMapping("/community")
public class CommunityController {
    private static final Logger log = LoggerFactory.getLogger(CommunityController.class);

    private final CommunityService communityService;

    private final UserService userService;

    @RequestMapping("/list")
    public String list(HttpSession session, HttpServletRequest request) {

        // 검색관련------------------------
        String col = Utility.checkNull(request.getParameter("col"));
        String word = Utility.checkNull(request.getParameter("word"));

        if (col.equals("total")) {
            word = "";
        }

        // 페이지관련-----------------------
        int nowPage = 1;// 현재 보고있는 페이지
        if (request.getParameter("nowPage") != null) {
            nowPage = Integer.parseInt(request.getParameter("nowPage"));
        }
        int recordPerPage = 5;// 한페이지당 보여줄 레코드갯수

        // DB에서 가져올 순번-----------------
        int sno = ((nowPage - 1) * recordPerPage) + 1;
        int eno = nowPage * recordPerPage;

        Map map = new HashMap();
        map.put("col", col);
        map.put("word", word);
        map.put("sno", sno);
        map.put("eno", eno);
        map.put("cnt", recordPerPage);

        int total = communityService.totalCommunity();

//        List<CommunityResponseDto> list = service.list(map);
        List<CommunityResponseDto> list = communityService.findAllCommunity();

        String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

        // request에 Model사용 결과 담는다
        request.setAttribute("list", list);
        request.setAttribute("nowPage", nowPage);
        request.setAttribute("col", col);
        request.setAttribute("word", word);
        request.setAttribute("paging", paging);

        return "/community/list";
    }

    @GetMapping("/read/{communityId}")
    public String read(@PathVariable("communityId") Long communityId, Model model) {

        //service.upCnt(cid);

        CommunityResponseDto communityResponseDto = communityService.findCommunityById(communityId);

        model.addAttribute("dto", communityResponseDto);

        /* 댓글 처리 끝 */

        return "/community/read";
    }

    @GetMapping("/create")
    public String create(HttpSession session, Model model) {
        log.info("GET : community create");

        String userEmail = (String) session.getAttribute("userEmail");
        UserResponseDto userResponseDto = userService.findUserByEmail(userEmail);
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userName", userResponseDto.getUserName());

        return "/community/create";
    }

    @PostMapping("/create")
    public String create(@RequestParam Map<String, String> map) {

        log.info(map.get("userEmail"));

        if (communityService.registerCommunity(map) > 0) {
            return "redirect:/community/list";
        } else {
            return "/error";
        }

    }


    @GetMapping("/update")
    public String update(Long communityId, HttpServletRequest request, HttpSession session) {
        log.info("GET : community update");

        CommunityResponseDto communityResponseDto = communityService.findCommunityById(communityId);

        request.setAttribute("dto", communityResponseDto);

        return "/community/update";
    }

    @GetMapping("/delete")
    public String deleteForm() {
        log.info("GET : community delete");

        return "/community/delete";
    }


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
