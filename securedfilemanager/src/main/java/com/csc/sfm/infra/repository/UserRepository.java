package com.csc.sfm.infra.repository;

import com.csc.sfm.domain.User;

public interface UserRepository {

  public User getByUsername(String username);
  
  public void save(User user);
  public void update(User user);
  public void delete(User user);
}
