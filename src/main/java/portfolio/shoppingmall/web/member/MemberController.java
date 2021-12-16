package portfolio.shoppingmall.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import portfolio.shoppingmall.domain.member.Member;
import portfolio.shoppingmall.domain.member.MemberRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("member") Member member) {return "members/joinForm";}

    @PostMapping("/join")
    public String save(@Validated @ModelAttribute Member member, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "members/joinForm";
        }
        memberRepository.save(member);
        return "redirect:/";
    }
}
