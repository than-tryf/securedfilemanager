package com.csc.sfm.server.application.service.impl;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csc.sfm.server.application.exception.NotYetImplementedException;
import com.csc.sfm.server.application.service.ConnectionService;
import com.csc.sfm.server.domain.User;
import com.csc.sfm.server.infra.repository.UserRepository;

@Service("connectionService")
public class ConnectionServiceImpl implements ConnectionService {

  @Autowired
  private UserRepository userRepository;
  
  /*
   * PUBLIC
   */

  @Override
  @Transactional
  public User connect(String username, String password) {
  	if (username == null || password == null) {
  		// TODO throws InvalidParameterException
  		return null;
  	}

  	User user = userRepository.getByUsername(username);
  	if (user == null) {
  		// TODO throws InvalidUsernameException
  		return null;
  	}

  	if (!password.equals(user.getPassword())) {
  		// TODO throws InvalidPasswordException
  		return null;
  	}
  	user.setLastConnectionDate(GregorianCalendar.getInstance().getTime());
  	userRepository.save(user);
  	return user;
  }

  @Override
  public void disconnect(User user) {
    // TODO
    throw new NotYetImplementedException();
  }

}
