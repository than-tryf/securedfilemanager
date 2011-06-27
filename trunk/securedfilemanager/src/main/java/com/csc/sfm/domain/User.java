package com.csc.sfm.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_USERS")
@NamedQuery(name="findUsersByUsername", query="SELECT u FROM User u WHERE u.username = :username")
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
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="ID")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name="CREATION_DATE", nullable=true)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
  
  @Column(name="MODIFICATION_DATE", nullable=true)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getModificationDate() {
    return modificationDate;
  }
  public void setModificationDate(Date modificationDate) {
    this.modificationDate = modificationDate;
  }
  
  @Column(name="USERNAME", length=30, nullable=false)
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  
  @Column(name="PASSWORD", length=30, nullable=false)
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  @Column(name="ACTIVATED", nullable=false)
  public boolean isActivated() {
    return activated;
  }
  public void setActivated(boolean activated) {
    this.activated = activated;
  }
  
  @Column(name="LAST_CONNECTION_DATE", nullable=true)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getLastConnectionDate() {
    return lastConnectionDate;
  }
  public void setLastConnectionDate(Date lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  @JoinTable(
      name="T_ACCESSES",
      joinColumns = @JoinColumn( name="USER_ID"),
      inverseJoinColumns = @JoinColumn( name="ID")
  )
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
