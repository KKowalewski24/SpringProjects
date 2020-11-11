package pl.kkowalewski.forminput.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.kkowalewski.forminput.model.PersonForm;

import javax.validation.Valid;

import static pl.kkowalewski.forminput.constants.Constant.INDEX;
import static pl.kkowalewski.forminput.constants.Constant.REDIRECT;
import static pl.kkowalewski.forminput.constants.Constant.RESULTS;
import static pl.kkowalewski.forminput.constants.Constant.RESULTS_PATH;
import static pl.kkowalewski.forminput.constants.Constant.SLASH;

@Controller
public class WebController implements WebMvcConfigurer {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(RESULTS_PATH).setViewName(RESULTS);
    }

    @GetMapping(SLASH)
    public String showForm(PersonForm personForm) {
        return INDEX;
    }

    @PostMapping(SLASH)
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return INDEX;
        }

        return REDIRECT + RESULTS_PATH;
    }
}
