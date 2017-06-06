package com.forum.model;

import com.forum.configuration.ValidationTestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ValidationTestConfiguration.class})
public class ChannelValidationTest {

    @Autowired
    private Validator validator;

    @Test
    public void setChannelId() throws Exception {
        Channel channel = new Channel(1, "text", "text", LocalDateTime.now());

        Set<ConstraintViolation<Channel>> constraintViolations = validator.validate(channel);

        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void setName() throws Exception {
        Channel channel = new Channel(1, null, "text", LocalDateTime.now());

        Set<ConstraintViolation<Channel>> constraintViolations = validator.validate(channel);

        assertFalse(constraintViolations.isEmpty());
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void setDescription() throws Exception {
        Channel channel = new Channel(1, "text", new String(new byte[500]), LocalDateTime.now());

        Set<ConstraintViolation<Channel>> constraintViolations = validator.validate(channel);

        assertFalse(constraintViolations.isEmpty());
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void setDate() throws Exception {
        Channel channel = new Channel(1, "text", "text", LocalDateTime.now());

        Set<ConstraintViolation<Channel>> constraintViolations = validator.validate(channel);

        assertTrue(constraintViolations.isEmpty());
    }

}