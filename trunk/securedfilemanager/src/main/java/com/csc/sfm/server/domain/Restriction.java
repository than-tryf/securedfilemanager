package com.csc.sfm.server.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_RESTRICTIONS")
public class Restriction extends AbstractEntity {

  private Resource resource;

  /*
   * GETTERS & SETTERS
   */

  @ManyToOne
  @JoinColumn(name="PARENT_ID", nullable=false)
  public Resource getResource() {
    return resource;
  }
  public void setResource(Resource access) {
    this.resource = access;
  }
  
  /*
   * PUBLIC
   */
  
  /*
   * PRIVATE
   */
  
}
