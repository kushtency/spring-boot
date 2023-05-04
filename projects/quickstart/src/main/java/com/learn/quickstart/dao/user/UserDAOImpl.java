package com.learn.quickstart.dao.user;

import com.learn.quickstart.model.user.User;
import com.learn.quickstart.model.user.UserDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO{
    private EntityManager entityManager;
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public boolean save(User user) {
        try{
            entityManager.persist(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User find(UserDTO user) {
        try{
            User u = entityManager.createQuery("select u from User u where u.userName=:username", User.class)
                    .setParameter("username", user.getUserName())
                    .getSingleResult();
            return u;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
