package com.csc.sfm.application.service;

import com.csc.sfm.application.dataprovider.UserDP;

public interface ConnectionService {

  public UserDP connect(String username, String password);
  public void disconnect(UserDP user);

}
