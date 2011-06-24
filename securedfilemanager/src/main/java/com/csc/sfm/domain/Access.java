package com.csc.sfm.domain;

import java.util.Date;
import java.util.List;

public class Access {

  private Integer id;
  private Date creationDate;
  private Date modificationDate;
  private User user;
  private Resource resource;
  private AccessDurationType durationType;
  private Date startDate;
  private Date endDate;
  private List<Restriction> restrictions;
  
  /*
   * GETTERS & SETTERS
   */

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  
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

  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }
  
  public Resource getResource() {
    return resource;
  }
  public void setResource(Resource resource) {
    this.resource = resource;
  }
  
  public AccessDurationType getDurationType() {
    return durationType;
  }
  public void setDurationType(AccessDurationType durationType) {
    this.durationType = durationType;
  }
  
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public List<Restriction> getRestrictions() {
    return restrictions;
  }
  public void setRestrictions(List<Restriction> restrictions) {
    this.restrictions = restrictions;
  }
  
  /*
   * PUBLIC
   */
  
  /*
   * PRIVATE
   */

}
