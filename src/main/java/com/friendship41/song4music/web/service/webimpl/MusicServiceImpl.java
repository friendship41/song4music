package com.friendship41.song4music.web.service.webimpl;

import com.friendship41.song4music.repository.MusicRepository;
import com.friendship41.song4music.repository.entity.Music;
import com.friendship41.song4music.web.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("WebMusicService")
public class MusicServiceImpl implements MusicService
{
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public List<Music> getMusics(Long mListSeq)
    {
        return new ArrayList<>(musicRepository.findBymListSeq(mListSeq));
    }

    @Override
    public Music addMusicToList(Music music)
    {
        return musicRepository.save(music);
    }
}
