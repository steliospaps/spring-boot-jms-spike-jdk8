package com.github.steliospaps.spring.boot.jms.spike;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.steliospaps.spring.boot.jms.spike.config.InputMessage;
import com.mockrunner.jms.JMSTestModule;
import com.mockrunner.mock.jms.MockMessage;
import com.mockrunner.mock.jms.MockTextMessage;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Import(JmsConfiguration.class)
public class SpringBootJmsSpikeApplicationTests {
	
	@Autowired
	private JMSTestModule testModule;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void badMesageArrives() throws Exception {
		testModule.getQueue("inputQueueName").addMessage(new MockTextMessage("some text"));
	}
	@Test
	public void goodMesageArrives() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String val =  mapper.writeValueAsString(new InputMessage("hello World"));
		testModule.getQueue("inputQueueName").addMessage(new MockTextMessage(val));
	}
}
