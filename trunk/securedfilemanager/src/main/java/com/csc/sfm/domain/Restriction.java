package com.csc.sfm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_RESTRICTIONS")
public class Restriction {

  private Integer id;
  private Resource resource;

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
