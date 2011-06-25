package com.csc.sfm.application.service;

import com.csc.sfm.application.vo.UserVO;

public interface ConnectionService {

  public UserVO connect(String username, String password);
  public void disconnect(UserVO user);

}
