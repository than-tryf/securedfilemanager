package com.csc.sfm.infra.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.csc.sfm.domain.Access;
import com.csc.sfm.domain.User;

public class UserFactory {

  /*
   * PUBLIC
   */

  public User newInstance() {
    Date creationDate = GregorianCalendar.getInstance().getTime();
    return newInstance(null, "", "", creationDate, creationDate, false, null, new ArrayList<Access>());
  }

  public User newInstance(Integer id, String userName, String password, Date creationDate, Date modificationDate, 
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
