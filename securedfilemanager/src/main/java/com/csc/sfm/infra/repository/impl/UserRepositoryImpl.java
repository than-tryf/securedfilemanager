package com.csc.sfm.infra.repository.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.csc.sfm.domain.User;
import com.csc.sfm.infra.repository.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl extends AbstractEntityRepositoryImpl<User> implements UserRepository {

  public User getById(int id) {
    return em.find(User.class, id);
  }
  
  @SuppressWarnings("unchecked")
  public User getByUsername(String username) {
    User result = null;
    
    Query query = em.createNamedQuery("findUsersByUsername", User.class);
    query.setParameter("username", username);

    List<User> matchingUsers = query.getResultList();

    if (!matchingUsers.isEmpty()) {
      result = matchingUsers.get(0);
    }
    return result;
  }
  
  @SuppressWarnings("unchecked")
  public List<User> findAllUsers() {
    return em.createNamedQuery("findAllUsers").getResultList();
  }

}
