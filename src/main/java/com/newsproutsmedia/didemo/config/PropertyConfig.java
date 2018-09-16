package com.newsproutsmedia.didemo.config;

import com.newsproutsmedia.didemo.examplebeans.FakeDataSource;
import com.newsproutsmedia.didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
//or, for multiple property sources, you can use
//@PropertySources({
//        @PropertySource("classpath:datasource:properties"),
//        @PropertySource("classpath:jms.properties")
//})
// either is acceptable, but for large numbers of property files, @PropertySources is easier to read
public class PropertyConfig {

    // Pull override data from Environment Variables
    // Those are set up in "Edit Configurations"/Environment screen
//    @Autowired
//    Environment env;

    @Value("${com.username}")
    String user;

    @Value("${com.password}")
    String password;

    @Value("${com.dburl}")
    String url;

    @Value("${com.jms.username}")
    String jmsUsername;

    @Value("${com.jms.password}")
    String jmsPassword;

    @Value("${com.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        //fakeDataSource.setUser(env.getProperty("USERNAME"));
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker jmsBroker = new FakeJmsBroker();
        jmsBroker.setUsername(jmsUsername);
        jmsBroker.setPassword(jmsPassword);
        jmsBroker.setUrl(jmsUrl);
        return jmsBroker;
    }

    // reads and scans for properties file listed in @PropertySource annotation at top
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties() {
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        return propertySourcesPlaceholderConfigurer;
//    }

}
