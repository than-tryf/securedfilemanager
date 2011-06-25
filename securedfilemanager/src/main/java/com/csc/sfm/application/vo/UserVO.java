package com.csc.sfm.application.vo;

import java.util.Date;
import java.util.List;

import com.csc.sfm.domain.Access;
import com.csc.sfm.infra.util.EqualsUtil;

public class UserVO {

  private Date creationDate;
  private Date modificationDate;
  private String username;
  private String password;
  private boolean activated;
  private Date lastConnectionDate;
  private List<Access> accesses;

  /*
   * GETTERS & SETTERS
   */
  
  public Date getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getModificationDate() {
    return modificationDate;
  }
  public void setModificationDate(Date modificationDate) {
    this.modificationDate = modificationDate;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  public boolean isActivated() {
    return activated;
  }
  public void setActivated(boolean activated) {
    this.activated = activated;
  }
  
  public Date getLastConnectionDate() {
    return lastConnectionDate;
  }
  public void setLastConnectionDate(Date lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }
  
  public List<Access> getAccesses() {
    return accesses;
  }
  public void setAccesses(List<Access> accesses) {
    this.accesses = accesses;
  }

  
  /*
   * PUBLIC
   */
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserVO)) {
      return false;
    }
    UserVO u = (UserVO) o;
    return EqualsUtil.areEqual(this.username, u.getUsername()) &&
           EqualsUtil.areEqual(this.password, u.getPassword()) &&
           EqualsUtil.areEqual(this.activated, u.isActivated());
  }
  
  /*
   * PRIVATE
   */
}
