package com.forum.dao;

import com.forum.configuration.SpringTestDaoConfiguration;
import com.forum.model.Channel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringTestDaoConfiguration.class)
@Transactional
public class ChannelDaoImplTest {

    private static final Channel CHANNEL = new Channel("USA", "Make America great again");

    @Autowired
    private ChannelDao channelDao;

    @Test
    public void add() throws Exception {
        Integer channelId = channelDao.add(CHANNEL);
        assertNotNull("Returned id must be not null", channelId);

        Channel addedChannel = channelDao.getById(channelId);

        assertNotNull("Returned channel must be not null", addedChannel);
        assertEquals("Id", channelId, addedChannel.getChannelId());
        assertEquals("Name", CHANNEL.getName(), addedChannel.getName());
        assertEquals("Description", CHANNEL.getDescription(), addedChannel.getDescription());
    }

    @Test
    public void update() throws Exception {
        Integer channelId = channelDao.add(CHANNEL);
        assertNotNull("Returned id must be not null", channelId);

        Channel channel = new Channel("Test", "Description");
        channel.setChannelId(1);
        channelDao.update(channel);

        Channel updatedChannel = channelDao.getById(1);

        assertNotNull("Returned channel must be not null", updatedChannel);
        assertEquals("Id", channel.getChannelId(), updatedChannel.getChannelId());
        assertEquals("Name", channel.getName(), updatedChannel.getName());
        assertEquals("Description", channel.getDescription(), updatedChannel.getDescription());
    }

    @Test
    public void delete() throws Exception {
        Integer channelId = channelDao.add(CHANNEL);
        assertNotNull("Returned id must be not null", channelId);

        channelDao.delete(channelId);

        Channel deletedChannel = channelDao.getById(channelId);
        assertNull("Returned channel must be not null", deletedChannel);
    }

    @Test
    public void getAll() throws Exception {
        Integer channelId = channelDao.add(CHANNEL);
        assertNotNull("Returned id must be not null", channelId);

        List<Channel> channelList = channelDao.getAll();
        channelList.stream().forEach(channel -> System.out.println(channel.toString()));

        assertNotNull("Returned channel list must be not null", channelList);
        assertTrue("Channel list must have one or more channels", channelList.size() > 1);
    }

    @Test
    public void getById() throws Exception {
        Integer channelId = channelDao.add(CHANNEL);
        assertNotNull("Returned id must be not null", channelId);

        Channel channel = channelDao.getById(channelId);

        assertNotNull("Returned channel must be not null", channel);
        assertEquals("Id", channelId, channel.getChannelId());
        assertEquals("Name", CHANNEL.getName(), channel.getName());
        assertEquals("Description", CHANNEL.getDescription(), channel.getDescription());
    }
}