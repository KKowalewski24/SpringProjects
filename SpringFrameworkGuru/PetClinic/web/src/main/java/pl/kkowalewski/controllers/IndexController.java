package pl.kkowalewski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String ROOT = "";
    public static final String SLASH = "/";
    public static final String INDEX = "/index";
    public static final String INDEX_HTML = "/index.html";

    /*------------------------ METHODS REGION ------------------------*/
    //SUBSTRING() IS USED TO REMOVE SLASH(/) FROM MAPPING
    @RequestMapping({ROOT, SLASH, INDEX, INDEX_HTML})
    public String index() {
        return INDEX.substring(1);
    }
}
