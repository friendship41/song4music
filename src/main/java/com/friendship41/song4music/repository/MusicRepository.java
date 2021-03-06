package com.friendship41.song4music.repository;

import com.friendship41.song4music.repository.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long>
{
    public List<Music> findBymListSeq(Long mListSeq);
}
