package com.csc.sfm.infra.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.csc.sfm.domain.Access;
import com.csc.sfm.domain.User;

@Component
@Scope("singleton")
public class UserFactory {

//  /*
//   * SINGLETON
//   */
//  
//  private UserFactory() {
//    super();
//  }
//  
//  private static UserFactory instance;
//  
//  public static UserFactory getInstance() {
//    if (instance == null) {
//      instance = new UserFactory();
//    }
//    return instance;
//  }
  
  /*
   * PUBLIC
   */

  public User createUser() {
    Date creationDate = GregorianCalendar.getInstance().getTime();
    return createUser(null, "", "", creationDate, creationDate, false, null, new ArrayList<Access>());
  }

  public User createUser(Integer id, String userName, String password, Date creationDate, Date modificationDate, 
      boolean activated, Date lastConnectionDate, List<Access> accesses) {
    User user = new User();
    
    user.setId(id);
    user.setUsername(userName);
    user.setPassword(password);
    user.setCreationDate(creationDate);
    user.setModificationDate(modificationDate);
    user.setActivated(activated);
    user.setAccesses(accesses);
    
    return user;
  }
  
}
