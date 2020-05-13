package com.friendship41.song4music.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "MUSICLIST_SORT")
@SequenceGenerator(
        name = "M_SORT_SEQUENCE_GEN",
        sequenceName = "M_SORT_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class MusicSort
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "M_SORT_SEQUENCE_GEN")
    private Long mSortSeq;

    private String mSortName;
}
