package portfolio.shoppingmall.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import portfolio.shoppingmall.domain.member.Member;
import portfolio.shoppingmall.domain.member.MemberRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setName("테스터");
        member.setPhone("010-1234-1234");
        member.setEmail("aaa@naver.com");

        memberRepository.save(member);
    }

}
