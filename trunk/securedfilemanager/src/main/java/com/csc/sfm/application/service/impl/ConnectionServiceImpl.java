package com.csc.sfm.application.service.impl;

import com.csc.sfm.application.dataprovider.UserDP;
import com.csc.sfm.application.exception.NotYetImplementedException;
import com.csc.sfm.application.service.ConnectionService;

public class ConnectionServiceImpl implements ConnectionService {

  /*
   * PUBLIC
   */

  @Override
  public UserDP connect(String username, String password) {
    // TODO
    throw new NotYetImplementedException();
  }

  @Override
  public void disconnect(UserDP user) {
    // TODO
    throw new NotYetImplementedException();
  }

}
