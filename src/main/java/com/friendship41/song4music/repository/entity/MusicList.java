package com.friendship41.song4music.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private Long mListRecommendation;
    private Long mListReadcount;
    private String mListComment;
    private Date mListWritedate;
    private String mListName;
}
