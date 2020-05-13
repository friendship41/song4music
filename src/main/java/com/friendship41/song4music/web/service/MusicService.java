package com.friendship41.song4music.web.service;

import com.friendship41.song4music.repository.entity.Music;

import java.util.List;

public interface MusicService
{
    public List<Music> getMusics(Long mListSeq);
}
