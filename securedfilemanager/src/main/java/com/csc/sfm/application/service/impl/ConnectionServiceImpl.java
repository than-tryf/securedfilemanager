package com.csc.sfm.application.service.impl;

import com.csc.sfm.application.exception.NotYetImplementedException;
import com.csc.sfm.application.service.ConnectionService;
import com.csc.sfm.application.vo.UserVO;
import com.csc.sfm.infra.repository.UserRepository;

public class ConnectionServiceImpl implements ConnectionService {

  private UserRepository userRepository;
  
  /*
   * PUBLIC
   */

  @Override
  public UserVO connect(String username, String password) {
    // TODO
    throw new NotYetImplementedException();
  }

  @Override
  public void disconnect(UserVO user) {
    // TODO
    throw new NotYetImplementedException();
  }

}
