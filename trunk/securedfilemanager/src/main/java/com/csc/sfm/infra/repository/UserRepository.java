package com.csc.sfm.infra.repository;

import java.util.List;

import com.csc.sfm.domain.User;

public interface UserRepository extends AbstractEntityRepository<User> {

  public User getByUsername(String username);
  public List<User> findAllUsers();

}
