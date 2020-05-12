package com.friendship41.song4music.web.service;

import com.friendship41.song4music.repository.entity.MusicList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MusicListService
{
    public Page<MusicList> getMusicList(String MMemberId, Pageable pageable);
}
