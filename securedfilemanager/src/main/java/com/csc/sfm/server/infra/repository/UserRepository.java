package com.csc.sfm.server.infra.repository;

import java.util.List;

import com.csc.sfm.server.domain.User;

public interface UserRepository extends AbstractEntityRepository<User> {

  public User getByUsername(String username);
  public List<User> findAllUsers();

}
