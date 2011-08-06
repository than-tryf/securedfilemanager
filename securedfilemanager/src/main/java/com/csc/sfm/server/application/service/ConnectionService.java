package com.csc.sfm.server.application.service;

import com.csc.sfm.server.domain.User;

public interface ConnectionService {

  public User connect(String username, String password);
  public void disconnect(User user);

}
