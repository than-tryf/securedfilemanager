package com.csc.sfm.infra.repository.impl;

import com.csc.sfm.application.exception.NotYetImplementedException;
import com.csc.sfm.domain.User;
import com.csc.sfm.infra.repository.UserRepository;

public class UserRepositoryImpl extends Repository implements UserRepository {

  @Override
  public User getByUsername() {
    throw new NotYetImplementedException();
  }

}
