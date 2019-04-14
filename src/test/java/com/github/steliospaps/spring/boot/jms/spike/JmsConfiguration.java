package com.github.steliospaps.spring.boot.jms.spike;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.mockrunner.jms.ConfigurationManager;
import com.mockrunner.jms.DestinationManager;
import com.mockrunner.jms.JMSTestModule;
import com.mockrunner.mock.jms.JMSMockObjectFactory;

@TestConfiguration
public class JmsConfiguration {
	//clopy paste from https://github.com/mockrunner/mockrunner/blob/master/mockrunner-jms-spring/src/main/java/com/mockrunner/jms/spring/MockRunnerJMSConfiguration.java
	@Bean
    DestinationManager destinationManager() {
        return mockFactory().getDestinationManager();
    }

    @Bean
    ConfigurationManager configurationManager() {
        return mockFactory().getConfigurationManager();
    }
    
    @Bean
    JMSMockObjectFactory mockFactory() {
        return new JMSMockObjectFactory();
    }
    
    @Bean
    JMSTestModule jmsTestModule () {
        return new JMSTestModule(mockFactory());
    }
    
    @Bean
    ConnectionFactory connectionFactory() {
        return mockFactory().getMockQueueConnectionFactory();
    }

}
