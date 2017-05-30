package com.forum.dao;

import com.forum.aop.annotation.Loggable;
import com.forum.model.Channel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDaoImpl extends AbstractDao<Channel> implements ChannelDao {

    @Autowired
    private Environment environment;

    @Loggable
    @Override
    public Integer add(Channel channel) {
        return (Integer) this.create(channel);
    }

    @Loggable
    @Override
    public void update(Channel channel) {
        super.update(channel);
    }

    @Loggable
    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Loggable
    @Override
    public List<Channel> getAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery(environment.getProperty("sql.channel.getAll"));
        List<Channel> channelList = query.list();

        return channelList;
    }

    @Loggable
    @Override
    public Channel getById(Integer id) {
        return this.read(id);
    }
}
