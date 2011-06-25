package com.csc.sfm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.csc.sfm.application.exception.NotYetImplementedException;

@Entity
@Table(name="T_RESOURCES")
public class Resource {

  private Integer id;
  private String name;
  private Resource parent;
  private Date creationDate;
  private Date modificationDate;
  
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

  @Column(name="NAME")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public Resource getParent() {
    return parent;
  }
  public void setParent(Resource parent) {
    this.parent = parent;
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
  
  /*
   * PUBLIC
   */
  
  public String getUrl() {
    // TODO
    throw new NotYetImplementedException();
  }
  
  /*
   * PRIVATE
   */

}
