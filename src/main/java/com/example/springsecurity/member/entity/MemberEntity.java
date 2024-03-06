package com.example.springsecurity.member.entity;

import com.example.springsecurity.common.entity.BaseEntity;
import com.example.springsecurity.common.enums.MemberRole;
import com.example.springsecurity.common.security.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Builder
@Setter
@Getter
@Table(name = "tb_member")
@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq", nullable = false)
    private long memberSeq;

    @Column(name = "member_id", unique = true)
    private String memberId;

    @Column(name = "password")
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberRole role;

    public MemberDTO toEntity() {
        return MemberDTO.builder()
                .memberSeq(memberSeq)
                .memberId(memberId)
                .role(role)
                .password(password)
                .build();
    }

}
