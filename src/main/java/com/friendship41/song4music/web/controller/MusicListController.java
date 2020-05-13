package com.friendship41.song4music.web.controller;

import com.friendship41.song4music.repository.entity.MusicList;
import com.friendship41.song4music.web.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicListController
{
    @Autowired
    @Qualifier("WebMusicListService")
    private MusicListService webMusicListService;

    @PostMapping(value = "/musics")
    public String addMusicList(MusicList musicList)
    {
        webMusicListService.addMusicList(musicList);
        return "redirect:/";
    }
}
