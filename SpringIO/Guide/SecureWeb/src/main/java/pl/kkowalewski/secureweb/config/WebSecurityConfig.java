package pl.kkowalewski.secureweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static pl.kkowalewski.secureweb.constant.Constants.HOME_PATH;
import static pl.kkowalewski.secureweb.constant.Constants.LOGIN_PATH;
import static pl.kkowalewski.secureweb.constant.Constants.PASSWORD;
import static pl.kkowalewski.secureweb.constant.Constants.SLASH;
import static pl.kkowalewski.secureweb.constant.Constants.USERNAME;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(SLASH, HOME_PATH).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(LOGIN_PATH)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder()
                        .username(USERNAME)
                        .password(PASSWORD)
                        .roles()
                        .build()
        );
    }
}
