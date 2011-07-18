package com.csc.sfm.server.infra.repository;

import com.csc.sfm.server.domain.User;

public interface UserRepository extends EntityRepository<User> {

  public User getByUsername(String username);

}
