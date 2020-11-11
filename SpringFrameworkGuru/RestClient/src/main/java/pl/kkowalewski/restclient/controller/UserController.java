package pl.kkowalewski.restclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;
import pl.kkowalewski.restclient.service.ApiService;

@Controller
public class UserController {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String ROOT = "";
    public static final String SLASH = "/";
    public static final String INDEX = "index";
    public static final String USERS = "users";
    public static final String LIMIT = "limit";
    public static final String USER_LIST = "userlist";

    private final ApiService apiService;

    /*------------------------ METHODS REGION ------------------------*/
    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({ROOT, SLASH, "/" + INDEX})
    public String index() {
        return INDEX;
    }

    @PostMapping("/" + USERS)
    public String formPost(Model model, ServerWebExchange serverWebExchange) {
        model.addAttribute(USERS, apiService.prepareUsers(serverWebExchange
                .getFormData().map(data -> new Integer(data.getFirst(LIMIT)))));

        return USER_LIST;
    }
}
