package com.example.springsecurity.common.security.util;

import com.example.springsecurity.common.security.dto.MemberDTO;
import com.example.springsecurity.common.security.dto.MemberDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateUtil {

    public MemberDTO getAuthenticatedUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MemberDTO memberDTO = null;

         if (authentication != null && authentication.isAuthenticated()){
             MemberDetails memberDetails = (MemberDetails) authentication.getPrincipal();

             memberDTO = memberDetails.getMemberDTO();
         }

         return memberDTO;
    }

}
