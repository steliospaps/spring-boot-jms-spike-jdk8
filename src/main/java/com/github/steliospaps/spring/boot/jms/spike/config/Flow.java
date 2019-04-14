package com.github.steliospaps.spring.boot.jms.spike.config;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.handler.LoggingHandler.Level;
import org.springframework.integration.jms.dsl.Jms;
import org.springframework.integration.support.converter.SimpleMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class Flow {
	@Bean
	public IntegrationFlow HelloWorldFlow(ConnectionFactory connectionFactory) {
		return IntegrationFlows.from( 
				Jms.messageDrivenChannelAdapter(connectionFactory)
/*				Jms.inboundAdapter(connectionFactory)
					.configureJmsTemplate(t -> t
							.deliveryPersistent(true)
							//.jmsMessageConverter(messageConverter())
							)
					*/
					.destination("inputQueueName")
				)
				.transform(Transformers.fromJson(InputMessage.class))
				.log(Level.INFO)
				.handle(h -> {})
				.get();
	}
}
