package pl.kkowalewski.testingweblayer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static pl.kkowalewski.testingweblayer.constants.Constant.INDEX;
import static pl.kkowalewski.testingweblayer.constants.Constant.SLASH;

@Controller
public class IndexController {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    @ResponseBody
    @RequestMapping(SLASH)
    public String index() {
        return INDEX;
    }
}
