package com.friendship41.song4music.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MUSICLIST_LIST")
@SequenceGenerator(
        name = "M_LIST_SEQUENCE_GEN",
        sequenceName = "M_LIST_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class MusicList
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "M_LIST_SEQUENCE_GEN")
    private Long mListSeq;

    private String mMemberId;
    private Long mMusicSeq;
    private String mListRecommendation;
    private Long mListReadcount;
    private Long mListComment;
}
