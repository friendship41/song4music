package com.friendship41.song4music.web.controller;

import com.friendship41.song4music.repository.entity.Music;
import com.friendship41.song4music.web.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicController
{
    @Autowired
    @Qualifier("WebMusicService")
    private MusicService webMusicService;

    @GetMapping(value = "/musics")
    public List<Music> getMusics(@RequestParam("mListSeq") Long mListSeq)
    {
        return webMusicService.getMusics(mListSeq);
    }

    @PostMapping(value = "/music")
    public Music addMusic(Music music)
    {
        try
        {
            return webMusicService.addMusicToList(music);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
