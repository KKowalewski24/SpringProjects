package pl.kkowalewski.secureweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static pl.kkowalewski.secureweb.constant.Constants.HELLO;
import static pl.kkowalewski.secureweb.constant.Constants.HELLO_PATH;
import static pl.kkowalewski.secureweb.constant.Constants.HOME;
import static pl.kkowalewski.secureweb.constant.Constants.HOME_PATH;
import static pl.kkowalewski.secureweb.constant.Constants.LOGIN;
import static pl.kkowalewski.secureweb.constant.Constants.LOGIN_PATH;
import static pl.kkowalewski.secureweb.constant.Constants.SLASH;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(SLASH).setViewName(HOME);
        registry.addViewController(HOME_PATH).setViewName(HOME);
        registry.addViewController(HELLO_PATH).setViewName(HELLO);
        registry.addViewController(LOGIN_PATH).setViewName(LOGIN);
    }
}
