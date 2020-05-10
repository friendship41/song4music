package com.friendship41.song4music.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{
    @Value("${app_key}")
    private String app_key;

    @Value("${redirect_uri}")
    private String redirect_uri;

    @Value("${response_type}")
    private String response_type;

    @RequestMapping(value = "/loginPage")
    public String goToLoginPage(Model model){
        model.addAttribute("app_key", app_key);
        model.addAttribute("redirect_uri", redirect_uri);
        model.addAttribute("response_type", response_type);
        return "login.html";
    }

    @RequestMapping(value = "/kakao_oauth")
    public String kakaoAuth(@RequestParam("code")String code)
    {
        System.out.println(code);
        return "index.html";
    }
}
