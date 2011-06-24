package com.csc.sfm.domain;

import java.util.Date;

import com.csc.sfm.application.exception.NotYetImplementedException;

public class Resource {

  private Integer id;
  private String name;
  private Resource parent;
  private Date creationDate;
  private Date modificationDate;
  
  /*
   * GETTERS & SETTERS
   */
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

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
