package com.friendship41.song4music.web.service.webimpl;

import com.friendship41.song4music.repository.MemberRepository;
import com.friendship41.song4music.repository.entity.Member;
import com.friendship41.song4music.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
