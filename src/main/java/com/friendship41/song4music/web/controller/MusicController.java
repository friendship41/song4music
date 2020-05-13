package com.friendship41.song4music.web.controller;

import com.friendship41.song4music.repository.entity.Music;
import com.friendship41.song4music.web.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MusicController
{
    @Autowired
    @Qualifier("WebMusicService")
    private MusicService webMusicService;

    @RequestMapping(value = "/musics", method = RequestMethod.GET)
    @ResponseBody
    public List<Music> getMusics(@RequestParam("mListSeq") Long mListSeq)
    {
        return webMusicService.getMusics(mListSeq);
    }
}
