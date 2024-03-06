package com.example.springsecurity.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity{

    @Column(name = "reg_member_seq", updatable = false)
    @ColumnDefault("0")
    private long regMemberSeq;

    @CreatedDate
    @Column(name = "reg_date", nullable = false, updatable = false)
    private LocalDateTime regDate;

    @LastModifiedBy
    @Column(name = "mod_member_seq")
    @ColumnDefault("0")
    private long modMemberSeq;

    @LastModifiedDate
    @Column(name = "mod_date")
    private LocalDateTime modDate;

}
