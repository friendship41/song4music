package com.friendship41.song4music.web.service.webimpl;

import com.friendship41.song4music.repository.MemberRepository;
import com.friendship41.song4music.repository.entity.Member;
import com.friendship41.song4music.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("WebMemberService")
public class MemberServiceImpl implements MemberService
{
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getMemberList()
    {
        return new ArrayList<>(memberRepository.findAll());
    }

    @Override
    public Member getMemberById(String mMemberId)
    {
        return memberRepository.findById(mMemberId).orElse(null);
    }

    @Override
    public Member save(Member member)
    {
        memberRepository.save(member);
        return member;
    }

    @Override
    public void updateTokenById(String mMemberId, Member member)
    {
        Optional<Member> e = memberRepository.findById(mMemberId);

        if(e.isPresent()){
            e.get().setMMemberAccessTok(member.getMMemberAccessTok());
            e.get().setMMemberRefreashTok(member.getMMemberRefreashTok());
            memberRepository.save(e.get());
        }
    }
}
