package portfolio.shoppingmall.web.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty
    private String loginid;
    @NotEmpty
    private String password;
}
