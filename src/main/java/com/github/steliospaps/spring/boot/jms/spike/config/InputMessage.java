package com.github.steliospaps.spring.boot.jms.spike.config;
import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class InputMessage {
	private String request;
	@JsonCreator
	private InputMessage() {}
	
}
