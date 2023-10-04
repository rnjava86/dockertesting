package com.spring.jpa.h2.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.spring.jpa.h2.utils.Constants;

@Configuration
public class AppConfig {
	
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
	    JavaTimeModule module = new JavaTimeModule();
	    module.addSerializer(Constants.LOCAL_DATETIME_SERIALIZER);
	    return new ObjectMapper()
	      .setSerializationInclusion(JsonInclude.Include.NON_NULL)
	      .registerModule(module);
	}
	
	
}
