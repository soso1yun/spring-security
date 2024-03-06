package com.example.springsecurity.member.repository;

import com.example.springsecurity.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByMemberSeq(long memberSeq);

}
