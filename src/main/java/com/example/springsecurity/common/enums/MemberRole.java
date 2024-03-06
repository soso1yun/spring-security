package com.example.springsecurity.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {

    ADMIN("ROLE_ADMIN"),
    COMMON("ROLE_COMMON");

    private final String code;

}
