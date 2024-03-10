package me.junggunwoo.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class memberService {
    @Autowired
    MemberRepository memberRepository;

    public void test() {

        // 생성(create)
        // save() 메소드를 호출해 데이터 객체 저장
        // 전달 인수로 엔티티 Member를 넘기면 반환값으로 저장한 엔티티 반환받음
        memberRepository.save(new Member(1L, "A"));

        // 조회(read)
        // findById() 메소드에 id를 지정해 엔티티를 하나씩 조회
        // findAll() 메소드는 전체 엔티티 조회
        Optional<Member> member = memberRepository.findById(1L);
        List<Member> allMembers = memberRepository.findAll();

        // 삭제(delete)
        // deleteById() 메소드에 id를 지정하여 엔티티 삭제
        memberRepository.deleteById(1L);
    }
}
