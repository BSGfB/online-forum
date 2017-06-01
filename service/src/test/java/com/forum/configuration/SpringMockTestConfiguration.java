package com.forum.configuration;

import com.forum.dao.ChannelDao;
import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan({"com.forum.service", "com.forum.aop.aspect"})
public class SpringMockTestConfiguration {

    @Bean
    public ChannelDao channelDao() {
        return EasyMock.createMock(ChannelDao.class);
    }
}
