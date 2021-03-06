package com.friendship41.song4music.repository.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
@Table(name = "MUSICLIST_MEMBER")
public class Member
{
    @Id
    private String mMemberId;

    private String mMemberName;
    private String mMemberPassword;
    private String mMemberRole;
    private Date mMemberRegDate;
    private int mMemberLv;
    private int mMemberPoint;
    private String mMemberJoinpath;
    private String mMemberAccessTok;
    private String mMemberRefreashTok;
}
