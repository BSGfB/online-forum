package com.forum.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void update(T entity) {
        Session session = getCurrentSession();
        session.update(entity);
    }

    public void delete(Serializable id) {
        Session session = getCurrentSession();
        Object persistentInstance = session.load(persistentClass, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
    }

    public Serializable create(T entity) {
        Session session = getCurrentSession();
        Serializable identifier = session.save(entity);
        session.flush();

        return identifier;
    }

    public T read(Serializable id) {
        Session session = getCurrentSession();
        T entity = session.get(persistentClass, id);

        return entity;
    }
}
