package com.example.springsecurity.common.security.dto;

import com.example.springsecurity.common.enums.MemberRole;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDTO {

    private long memberSeq;
    private String memberId;
    private MemberRole role;
    private String password;

}
