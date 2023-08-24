package com.itwill.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class TestController {


    @GetMapping("/") // GET 방식의 /post/list 요청 주소를 처리하는 메서드.
    public String list() {
       
        return "test";
    }
}
