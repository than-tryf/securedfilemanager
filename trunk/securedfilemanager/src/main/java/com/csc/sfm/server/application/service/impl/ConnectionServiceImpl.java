package com.csc.sfm.server.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.csc.sfm.server.application.exception.NotYetImplementedException;
import com.csc.sfm.server.application.service.ConnectionService;
import com.csc.sfm.server.domain.User;
import com.csc.sfm.server.infra.repository.UserRepository;

public class ConnectionServiceImpl implements ConnectionService {

  @Autowired
  private UserRepository userRepository;
  
  /*
   * PUBLIC
   */

  @Override
  public User connect(String username, String password) {
    // TODO
    throw new NotYetImplementedException();
  }

  @Override
  public void disconnect(User user) {
    // TODO
    throw new NotYetImplementedException();
  }

}
