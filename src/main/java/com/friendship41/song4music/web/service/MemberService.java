package com.friendship41.song4music.web.service;

import com.friendship41.song4music.repository.entity.Member;

import java.util.List;

public interface MemberService
{
    public List<Member> getMemberList();
    public Member getMemberById(String mMemberId);
    public Member save(Member member);
    public void updateTokenById(String mMemberId, Member member);
}
