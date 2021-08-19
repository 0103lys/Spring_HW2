package com.koreait.day3.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data

@AllArgsConstructor
@NoArgsConstructor

@Entity

@SequenceGenerator(
        name="seq_user",            // 직접 이름 짓기
        sequenceName = "seq_user",  // 오라클에 있는 sequence이름과 동일해야함
        initialValue = 1,           // 초기 value값
        allocationSize = 1          // size 1씩 증가
)
@Builder
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long id;       // 일련번호
    private String userid; // 아이디
    private String userpw; // 비밀번호
    private String name;   // 이름
    private String status; // 상태
    private LocalDateTime lastLoginAt; // 마지막 접속시간
    private LocalDateTime regDate; // 가입날짜
}
