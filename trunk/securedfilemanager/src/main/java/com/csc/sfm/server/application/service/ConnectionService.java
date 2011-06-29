package com.csc.sfm.server.application.service;

import com.csc.sfm.shared.bean.UserVO;

public interface ConnectionService {

  public UserVO connect(String username, String password);
  public void disconnect(UserVO user);

}