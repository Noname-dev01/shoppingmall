package portfolio.shoppingmall.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portfolio.shoppingmall.domain.member.Member;
import portfolio.shoppingmall.domain.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){
        return memberRepository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
}
