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
        List<Member> memberList = new ArrayList<>();
        memberRepository.findAll().forEach(e -> memberList.add(e));
        return memberList;
    }

    @Override
    public Member getMemberById(String mMemberId)
    {
        Optional<Member> member = null;
        try
        {
            member = memberRepository.findById(mMemberId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return member.orElse(null);
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
        Optional<Member> e = null;
        try
        {
            e = memberRepository.findById(mMemberId);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }

        if(e.isPresent()){
            e.get().setMMemberAccessTok(member.getMMemberAccessTok());
            e.get().setMMemberRefreashTok(member.getMMemberRefreashTok());
        }
        memberRepository.save(e.get());
    }
}
