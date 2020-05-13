package com.friendship41.song4music.web.service;

import com.friendship41.song4music.repository.entity.Music;
import com.friendship41.song4music.repository.entity.MusicSort;

import java.util.List;

public interface MusicService
{
    public List<Music> getMusics(Long mListSeq);
    public Music addMusicToList(Music music);
    public List<MusicSort> getAllMusicSort();
}
