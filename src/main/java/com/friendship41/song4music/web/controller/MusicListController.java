package com.friendship41.song4music.web.controller;

import com.friendship41.song4music.repository.entity.Member;
import com.friendship41.song4music.repository.entity.MusicList;
import com.friendship41.song4music.web.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MusicListController
{
    @Autowired
    @Qualifier("WebMusicListService")
    private MusicListService webMusicListService;

    @PostMapping(value = "/musics")
    public String addMusicList(MusicList musicList, HttpSession session)
    {
        Member member = (Member) session.getAttribute("member");
        musicList.setMMemberId(member.getMMemberId());
        System.out.println(musicList);
        System.out.println(webMusicListService.addMusicList(musicList));
        return "redirect:/";
    }
}
