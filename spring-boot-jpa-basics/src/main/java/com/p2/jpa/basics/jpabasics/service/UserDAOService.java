package com.p2.jpa.basics.jpabasics.service;

import com.p2.jpa.basics.jpabasics.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository //Interacts with DB
@Transactional //Makes all methods a Transaction
public class UserDAOService {

    @PersistenceContext //Tracks changes to the bean which are in Persistence Context
    private EntityManager entityManager;

    public Long insert(User user){
        entityManager.persist(user);
        return user.getId();
    }
}
