package com.friendship41.song4music.repository;

import com.friendship41.song4music.repository.entity.MusicList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicListRepository extends JpaRepository<MusicList, Long>
{
    public Page<MusicList> findBymMemberId(String mMemberId, Pageable pageable);
}
