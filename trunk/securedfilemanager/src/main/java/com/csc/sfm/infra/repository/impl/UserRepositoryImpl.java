package com.csc.sfm.infra.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.sfm.domain.User;
import com.csc.sfm.infra.repository.UserRepository;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository {

  private EntityManagerFactory emf;

  @PersistenceUnit
  public void setEntityManagerFactory(EntityManagerFactory emf) {
      this.emf = emf;
  }
  
  public User getById(int id) {
    User result = null;
    
    EntityManager em = emf.createEntityManager();
    try {
      result = em.find(User.class, id);
    } finally {
      if (em != null) {
        em.close();
      }
    }
    return result;
  }
  
  @SuppressWarnings("unchecked")
  public User getByUsername(String username) {
    User result = null;
    
    EntityManager em = emf.createEntityManager();
    try {
      Query query = em.createNamedQuery("findUsersByUsername", User.class);
      query.setParameter("username", username);
      List<User> matchingUsers = query.getResultList();
      if (!matchingUsers.isEmpty()) {
        result = matchingUsers.get(0);
      }
    } finally {
      if (em != null) {
        em.close();
      }
    }
    return result;
  }

  public void save(User user) {
    EntityManager em = emf.createEntityManager();
    try {
      em.persist(user);
      em.flush();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void update(User user) {
    EntityManager em = emf.createEntityManager();
    try {
      em.merge(user);
      em.flush();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void delete(User user) {
    EntityManager em = emf.createEntityManager();
    try {
      em.remove(user);
      em.flush();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }
}
