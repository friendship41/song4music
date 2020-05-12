package com.friendship41.song4music.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MUSICLIST_MUSIC")
@SequenceGenerator(
        name = "M_MUSIC_SEQUENCE_GEN",
        sequenceName = "M_MUSIC_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class Music
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "M_MUSIC_SEQUENCE_GEN")
    private Long mMusicSeq;

    private String mMemberId;
    private String mMusicName;
    private String mMusicArtist;
    private Long mSortSeq;
    private String mMusicComment;
}
