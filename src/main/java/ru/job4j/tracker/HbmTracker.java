package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(HbmTracker.class.getName());

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        LOG.info("add" + item);
        return item;
    }

    @Override
    public boolean replace(Integer id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item replaceItem = session.get(Item.class, id);
        if (replaceItem != null) {
            replaceItem.setName(item.getName());
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Session session = sf.openSession();
        session.beginTransaction();
        if (findById(id) != null){
            session.delete(session.get(Item.class, id));
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Item ");
        List<Item> list = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Item WHERE name = :name");
        query.setParameter("name", key);
        List<Item> list = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Item findById(Integer id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}