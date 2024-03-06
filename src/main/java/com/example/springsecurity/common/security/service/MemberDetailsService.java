package com.example.springsecurity.common.security.service;

import com.example.springsecurity.common.security.dto.MemberDetails;
import com.example.springsecurity.member.entity.MemberEntity;
import com.example.springsecurity.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        MemberEntity member = memberRepository.findByMemberSeq(Long.parseLong(memberId));

        if (member == null) {
            throw new UsernameNotFoundException("해당하는 사용자가 없습니다.");
        }

        return new MemberDetails(member.toEntity());
    }
}
