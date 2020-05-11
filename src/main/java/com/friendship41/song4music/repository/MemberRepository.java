package com.friendship41.song4music.repository;

import com.friendship41.song4music.repository.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>
{
    public Optional<Member> findById(String mMemberId);
}
