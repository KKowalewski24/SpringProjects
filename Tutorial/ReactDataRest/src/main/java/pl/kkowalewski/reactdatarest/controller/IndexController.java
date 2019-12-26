package pl.kkowalewski.reactdatarest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static pl.kkowalewski.reactdatarest.constant.Constants.INDEX;
import static pl.kkowalewski.reactdatarest.constant.Constants.PATH_HOME;

@Controller
public class IndexController {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    @RequestMapping(PATH_HOME)
    public String index() {
        return INDEX;
    }
}
