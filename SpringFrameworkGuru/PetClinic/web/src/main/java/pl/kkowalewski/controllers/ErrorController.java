package pl.kkowalewski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String OUPS = "/oups";
    public static final String OUPS_HTML = "/oups.html";
    public static final String ERROR_INDEX = "/error/index";
    public static final String ERROR_INDEX_HTML = "/error/index.html";

    /*------------------------ METHODS REGION ------------------------*/
    //SUBSTRING() IS USED TO REMOVE SLASH(/) FROM MAPPING
    @RequestMapping({OUPS, OUPS_HTML, ERROR_INDEX, ERROR_INDEX_HTML})
    public String error(Model model) {
        return ERROR_INDEX.substring(1);
    }
}
