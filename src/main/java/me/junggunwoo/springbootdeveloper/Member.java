package me.junggunwoo.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 퍼시스턴스 계층 - 리포지토리
// 모든 스토리지 관련 로직을 처리
// 데이터베이스에 접근하기 위한 객체인 DAO 사용할 수 있음

@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자
@AllArgsConstructor
@Getter
@Entity // 엔티티로 지정

public class Member {
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false) // name 이라는 not null 칼럼과 매핑
    private String name;
}
