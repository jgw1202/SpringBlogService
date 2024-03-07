package me.junggunwoo.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 비즈니스 계층 - 서비스
// 모든 비즈니스 로직을 처리
// 퍼시스턴스 계층에서 제공하는 서비스를 사용할 수도 있고, 권한을 부여하거나 유효성 검사를 함

@Service
public class TestService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
