package com.csc.sfm.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_ACCESSES")
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

  @Id
  @Column(name="")
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
  
  @Column(name="DURATION_TYPE")
  public AccessDurationType getDurationType() {
    return durationType;
  }
  public void setDurationType(AccessDurationType durationType) {
    this.durationType = durationType;
  }
  
  @Column(name="START_DATE")
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  
  @Column(name="END_DATE")
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
