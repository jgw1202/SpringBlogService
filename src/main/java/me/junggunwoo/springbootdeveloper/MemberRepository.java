package me.junggunwoo.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// 퍼시스턴스 계층 - 리포지토리
// 모든 스토리지 관련 로직을 처리
// 데이터베이스에 접근하기 위한 객체인 DAO 사용할 수 있음

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
