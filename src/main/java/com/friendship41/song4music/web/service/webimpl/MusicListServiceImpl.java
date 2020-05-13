package com.friendship41.song4music.web.service.webimpl;

import com.friendship41.song4music.repository.MusicListRepository;
import com.friendship41.song4music.repository.entity.MusicList;
import com.friendship41.song4music.web.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("WebMusicListService")
public class MusicListServiceImpl implements MusicListService
{
    @Autowired
    private MusicListRepository musicListRepository;

    @Override
    public Page<MusicList> getMusicList(String MMemberId, Pageable pageable)
    {
        return musicListRepository.findBymMemberId(MMemberId, pageable);
    }

    @Override
    public MusicList addMusicList(MusicList musicList)
    {
        musicList.setMListReadcount(0L);
        musicList.setMListReadcount(0L);
        musicList.setMListWritedate(new Date());
        return musicListRepository.save(musicList);
    }
}
