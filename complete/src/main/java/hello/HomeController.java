package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {
        return "Welcome to world of ldap!";
    }

    @GetMapping("getUser")
    public String getUser(UsernamePasswordAuthenticationToken user) {
        //Получение имени юзера
        LOGGER.info("user {}", user);
        LOGGER.info(((LdapUserDetailsImpl) user.getPrincipal()).getDn());
        return user.toString();
    }
}
