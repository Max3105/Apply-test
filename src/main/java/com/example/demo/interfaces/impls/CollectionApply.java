package com.example.demo.interfaces.impls;

import com.example.demo.entity.UsersEntity;
import com.example.demo.interfaces.Apply;
import com.example.demo.entity.Human;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CollectionApply implements Apply {

    private static final SessionFactory ourSessionFactory;

    private ObservableList<TreeItem<Human>> personList = FXCollections.observableArrayList();

    static {
        try {
            ourSessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public void add(Human human) {
        try (Session session = getSession()) {
            session.beginTransaction();
            UsersEntity hm = new UsersEntity(human);
            session.save(hm);
            session.getTransaction().commit();
        }
        getPersonList();
    }

    @Override
    public void edit(Human human) {
        try (Session session = getSession()) {
            session.beginTransaction();
            UsersEntity hm = session.find(UsersEntity.class, human.getId());
            hm.setName(human.getName());
            hm.setBirthday(human.getBirthday());
            hm.setAge(human.getAge());
            session.save(hm);
            session.getTransaction().commit();
        }
        getPersonList();
    }


    @Override
    public void delete(Human human) {
        try (Session session = getSession()) {
            session.beginTransaction();
            UsersEntity hm = session.find(UsersEntity.class, human.getId());
            session.delete(hm);
            session.getTransaction().commit();
        }
        getPersonList();
    }

    public ObservableList<TreeItem<Human>> getPersonList() {
        try (Session session = getSession()) {
            final Query<UsersEntity> query = session.createQuery("from UsersEntity");
            List<UsersEntity> humanEntities = query.list();

            personList.clear();

            for (UsersEntity entity : humanEntities) {
                TreeItem<Human> newHuman = new TreeItem<>();
                newHuman.setValue(new Human(
                        entity.getIdusers(),
                        entity.getName(),
                        entity.getAge(),
                        entity.getBirthday()));
                personList.add(newHuman);
            }

        }
        return personList;
    }

    private static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

}


