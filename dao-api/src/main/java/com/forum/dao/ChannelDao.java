package com.forum.dao;


import com.forum.model.Channel;

import java.util.List;

public interface ChannelDao {

    Integer add(Channel channel);

    void update(Channel channel);

    void delete(Integer id);

    List<Channel> getAll();

    Channel getById(Integer id);
}
