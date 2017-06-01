package com.forum.service;

import com.forum.configuration.SpringMockTestConfiguration;
import com.forum.dao.ChannelDao;
import com.forum.model.Channel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringMockTestConfiguration.class)
public class ChannelServiceImplMockTest {

    private static final Channel CHANNEL = new Channel("USA", "Make America great again");
    private static final Integer CHANNEL_ID = new Integer(1);

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ChannelDao channelDaoMock;

    @After
    public void clean() {
        verify(channelDaoMock);
    }

    @Before
    public void setUp() {
        reset(channelDaoMock);
    }

    @Test
    public void add() throws Exception {
        expect(channelDaoMock.add(CHANNEL)).andReturn(CHANNEL_ID);
        replay(channelDaoMock);

        Integer channelId = channelService.add(CHANNEL);

        assertNotNull("Id must be not null", channelId);
        assertEquals("Returned id ", CHANNEL_ID, channelId);
    }

    @Test
    public void update() throws Exception {
        channelDaoMock.update(CHANNEL);
        expectLastCall();
        replay(channelDaoMock);

        channelDaoMock.update(CHANNEL);
    }

    @Test
    public void delete() throws Exception {
        channelDaoMock.update(CHANNEL);
        expectLastCall();
        replay(channelDaoMock);

        channelDaoMock.update(CHANNEL);
    }

    @Test
    public void getAll() throws Exception {
        List<Channel> expectedChannelList = new ArrayList<>();
        expectedChannelList.add(CHANNEL);

        expect(channelDaoMock.getAll()).andReturn(expectedChannelList);
        replay(channelDaoMock);

        List<Channel> channelList = channelService.getAll();

        assertNotNull("List must be not null", channelList);
        assertEquals("List must have same size", expectedChannelList.size(), channelList.size());
    }

    @Test
    public void getById() throws Exception {
        expect(channelDaoMock.getById(CHANNEL_ID)).andReturn(CHANNEL);
        replay(channelDaoMock);

        Channel channel = channelService.getById(CHANNEL_ID);

        assertNotNull("Channel must be not null", channel);
        assertEquals("Returned channel", CHANNEL, channel);
    }

}