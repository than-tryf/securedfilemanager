package com.csc.sfm.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="T_USERS")
public class User {

  private Integer id;
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
  
  @Id
  @Column(name="ID")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name="CREATION_DATE")
  public Date getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
  
  @Column(name="MODIFICATION_DATE")
  public Date getModificationDate() {
    return modificationDate;
  }
  public void setModificationDate(Date modificationDate) {
    this.modificationDate = modificationDate;
  }
  
  @Column(name="USERNAME")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  
  @Column(name="PASSWORD")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  @Column(name="ACTIVATED")
  public boolean isActivated() {
    return activated;
  }
  public void setActivated(boolean activated) {
    this.activated = activated;
  }
  
  @Column(name="LAST_CONNECTION_DATE")
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
  
  /*
   * PRIVATE
   */

}
