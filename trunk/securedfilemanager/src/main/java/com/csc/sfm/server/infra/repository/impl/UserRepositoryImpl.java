package com.csc.sfm.server.infra.repository.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.csc.sfm.server.domain.User;
import com.csc.sfm.server.infra.repository.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User> implements UserRepository {

	@Override
  public User get(Integer id) {
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
	@Override
  public List<User> list() {
    return em.createNamedQuery("findAllUsers").getResultList();
  }

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
