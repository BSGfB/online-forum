package com.forum.service;

import com.forum.aop.annotation.Loggable;
import com.forum.dao.ChannelDao;
import com.forum.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.util.Assert.*;

@Loggable
@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelDao channelDao;

    @Override
    public Integer add(Channel channel) throws DataAccessException {
        notNull(channel, "channel must not be null");

        return channelDao.add(channel);
    }

    @Override
    public void update(Channel channel) throws DataAccessException {
        notNull(channel, "channel must not be null");
        notNull(channel.getChannelId(), "id must not be null");

        channelDao.update(channel);
    }

    @Override
    public void delete(Integer id) throws DataAccessException {
        notNull(id, "id must not be null");
        isTrue(id > 0, "id must be greater than 0");

        channelDao.delete(id);
    }

    @Override
    public List<Channel> getAll() throws DataAccessException {
        return channelDao.getAll();
    }

    @Override
    public Channel getById(Integer id) throws DataAccessException {
        notNull(id, "id must not be null");
        isTrue(id > 0, "id must be greater than 0");

        return channelDao.getById(id);
    }
}
