package com.forum.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidationTestConfiguration {

    @Bean
    public Validator getValidation() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

}
