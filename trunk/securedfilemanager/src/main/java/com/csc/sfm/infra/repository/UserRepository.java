package com.csc.sfm.infra.repository;

import com.csc.sfm.domain.User;

public interface UserRepository {

  public User getByUsername();
  
}
