package pc.springframework.demo.properties.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import pc.springframework.demo.properties.examplebeans.FakeDataSource;
import pc.springframework.demo.properties.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySource("classpath:demo_properties\\demodatasource.properties")
@PropertySources({
        @PropertySource("classpath:demo_properties\\demodatasource.properties"),
        @PropertySource("classpath:demo_properties\\demojms.properties")
})
public class PropertyConfig {

    @Autowired
    Environment env;

    //declare properties
    @Value("${pc.username}")
    String user;

    @Value("${pc.password}")
    String password;

    @Value("${pc.dburl}")
    String url;

    @Value("${pc.jms.username}")
    String jmsUsername;

    @Value("${pc.jms.password}")
    String jmsPassoword;

    @Value("${pc.jms.url}")
    String jmsUrl;

    @Bean
    @Qualifier("FakeDataSource")
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    @Qualifier("fakeDataSourceEnv")
    public FakeDataSource fakeDataSourceEnv() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        //fakeDataSource.setUser(user);
        // to test, add USERNAME to environment properties in InteliJ
        fakeDataSource.setUser(env.getProperty("USERNAME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }


    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker jmsBroker = new FakeJmsBroker();
        jmsBroker.setUsername(jmsUsername);
        jmsBroker.setPassword(jmsPassoword);
        jmsBroker.setUrl(jmsUrl);
        return jmsBroker;
    }


    // bean that will mach the values in the property file with the properties in the configuration class
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
