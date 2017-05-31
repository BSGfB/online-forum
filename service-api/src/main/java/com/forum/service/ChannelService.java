package com.forum.service;

import com.forum.model.Channel;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ChannelService {

    Integer add(Channel channel) throws DataAccessException;

    void update(Channel channel) throws DataAccessException;

    void delete(Integer id) throws DataAccessException;

    List<Channel> getAll() throws DataAccessException;

    Channel getById(Integer id) throws DataAccessException;
}
