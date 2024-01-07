package com.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppService {

    @PersistenceContext
    private EntityManager entityManager;

//    @Transactional
    public Person get(){
        return entityManager.find(Person.class, 1);
    }
}
