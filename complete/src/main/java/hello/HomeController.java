package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }

    @GetMapping("getUser")
    public String getUser(UserDetails test){
        UserDetails ud = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOGGER.info("test " + test);
        LOGGER.info("ud " + ud);
        return ud.toString();
    }
}
