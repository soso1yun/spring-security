package com.example.springsecurity.common.security.util;

import com.example.springsecurity.common.security.dto.MemberDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key;
    private final long accessTokenExpTime;


    public JwtUtil(
            @Value("${jwt.secret}") String secretKey,
            @Value("${jwt.expiration_time}") long accessTokenExpTime
    ) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        this.accessTokenExpTime = accessTokenExpTime;
    }


    /**
     * Access token 생성
     *
     * @return access token
     */
    public String createAccessToken(MemberDTO memberDTO) {
        return createToken(memberDTO, accessTokenExpTime);
    }


    /**
     * JWT 생성
     *
     * @param memberDTO
     * @param accessTokenExpTime
     * @return jwt
     */
    public String createToken(MemberDTO memberDTO, long accessTokenExpTime) {

        Claims claims = Jwts.claims();
        claims.put("memberSeq", memberDTO.getMemberSeq());
        claims.put("memberId", memberDTO.getMemberId());
        claims.put("role", memberDTO.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
                .setExpiration(Date.from(ZonedDateTime.now().plusSeconds(accessTokenExpTime).toInstant()))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * JWT claim
     * @param accessToken
     * @return Claims
     */
    public Claims parseClaims(String accessToken) throws ExpiredJwtException {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
    }

    public String getUserSeq(String token) {
        return String.valueOf(parseClaims(token).get("memberSeq", Integer.class));
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            e.fillInStackTrace();
        }

        return false;
    }


}
