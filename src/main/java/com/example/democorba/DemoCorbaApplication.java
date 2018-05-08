package com.example.democorba;

import com.example.democorba.service.BytesDataHolder;
import com.example.democorba.service.GreetingService;
import com.example.democorba.service.GreetingServiceHelper;
import com.example.democorba.service.GreetingServiceOperations;
import com.example.democorba.support.IorFileSupport;
import org.omg.CORBA.ORB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.JndiRmiProxyFactoryBean;

import javax.naming.Context;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@SpringBootApplication
public class DemoCorbaApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoCorbaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoCorbaApplication.class, args);
    }

    @Bean
    CommandLineRunner demoUsingNameService(GreetingServiceOperations greetingServiceViaNamingService) {
        return args -> callService(greetingServiceViaNamingService);
    }

    @Bean
    CommandLineRunner demoUsingIorFile(GreetingService greetingServiceViaIorFile) {
        return args -> callService(greetingServiceViaIorFile);
    }

    private void callService(GreetingServiceOperations service) {
        LOGGER.info(service.hello("Hi Shimizu."));
        BytesDataHolder responseDataHolder = new BytesDataHolder();
        service.execute("Hi Shimizu.".getBytes(StandardCharsets.UTF_8), responseDataHolder);
        LOGGER.info(new String(responseDataHolder.value, StandardCharsets.UTF_8));
    }

    @Bean(destroyMethod = "destroy")
    ORB orb() {
        return ORB.init(new String[]{}, null);
    }

    @Bean
    JndiRmiProxyFactoryBean greetingServiceViaNamingService(ORB orb) {
        JndiRmiProxyFactoryBean factoryBean = new JndiRmiProxyFactoryBean();
        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
        properties.setProperty(Context.PROVIDER_URL, "iiop://localhost:1050");
        properties.put("java.naming.corba.orb", orb);
        factoryBean.setJndiEnvironment(properties);
        factoryBean.setJndiName("GreetingService");
        factoryBean.setServiceInterface(GreetingService.class);
        return factoryBean;
    }

    @Bean
    GreetingServiceOperations greetingServiceViaIorFile(ORB orb) {
        String ior = new IorFileSupport().read();
        return GreetingServiceHelper.narrow(orb.string_to_object(ior));
    }

}