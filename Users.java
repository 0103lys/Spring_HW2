package com.koreait.day3.model.entity;

// getter, setter
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data

// 생성자
@AllArgsConstructor
// 파라미터가 없는 생성자
@NoArgsConstructor

@Entity

// 시퀀스
@SequenceGenerator(
        name="sequence_users",
        sequenceName = "sequence_users",
        initialValue = 1,
        allocationSize = 1
)

// 메소드 체이닝
@Builder
public class Users {
    @Id // identity가 있어야함
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_users")
    private Long id;

    private String userid;
    private String userpw;
    private String hp;
    private String email;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}