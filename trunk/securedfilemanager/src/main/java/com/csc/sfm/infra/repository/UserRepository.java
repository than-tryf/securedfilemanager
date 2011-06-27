package com.csc.sfm.infra.repository;

import com.csc.sfm.domain.User;

public interface UserRepository {

  public void save(User user);
  public void update(User user);
  public void delete(User user);

  public User getById(int id);
  public User getByUsername(String username);

}
