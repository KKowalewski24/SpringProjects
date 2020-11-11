package pl.kkowalewski.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import pl.kkowalewski.exampleBeans.FakeDataSource;
import pl.kkowalewski.exampleBeans.FakeJmsBroker;

@Configuration
public class PropertyConfig {

    /*------------------------ FIELDS REGION ------------------------*/
    private static PropertySourcesPlaceholderConfigurer configurer;

    @Value("${kkowalewski.name}")
    String user;

    @Value("${kkowalewski.password}")
    String password;

    @Value("${kkowalewski.desc}")
    String url;

    @Value("${kkowalewski.jms.name}")
    String jmsUser;

    @Value("${kkowalewski.jms.password}")
    String jmsPassword;

    @Value("${kkowalewski.jms.desc}")
    String jmsUrl;

    /*------------------------ METHODS REGION ------------------------*/
    @Bean
    public FakeDataSource makeFakeDataSource() {
        FakeDataSource source = new FakeDataSource(user, password, url);

        return source;
    }

    @Bean
    public FakeJmsBroker makeFakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker(jmsUser, jmsPassword, jmsUrl);

        return fakeJmsBroker;
    }
}
