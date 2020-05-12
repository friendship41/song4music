package com.friendship41.song4music.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController
{
    @RequestMapping(value = "/")
    public String goToIndexPage()
    {
        return "index.html";
    }


}
