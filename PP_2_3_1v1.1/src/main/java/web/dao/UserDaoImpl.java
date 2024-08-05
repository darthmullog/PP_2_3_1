package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.model.User;

import javax.persistence.EntityManager;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override

    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override

    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
}
