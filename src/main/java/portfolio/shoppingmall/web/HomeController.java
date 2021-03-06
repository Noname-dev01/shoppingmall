package portfolio.shoppingmall.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import portfolio.shoppingmall.domain.member.Member;
import portfolio.shoppingmall.domain.member.MemberRepository;
import portfolio.shoppingmall.web.session.SessionManager;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    @GetMapping("/")
    public String index(@SessionAttribute(name=SessionConst.LOGIN_MEMBER,
            required = false)Member loginMember, Model model) {

        if (loginMember == null){
            return "index";
        }
        //세션 유지되면 로그인으로 이동
        model.addAttribute("member",loginMember);
        return "loginHome";
    }

    @GetMapping("/customerService")
    public String customerService(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)
                                              Member loginMember, Model model) {

        if (loginMember == null){
            return "service/customerService";
        }
        model.addAttribute("member",loginMember);

        return "service/loginCustomerService";
    }

}
