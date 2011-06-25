package com.csc.sfm.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DIRECTORY")
public class Directory extends Resource {

  private List<Resource> children;

  /*
   * GETTERS & SETTERS
   */
  
  public List<Resource> getChildren() {
    return children;
  }
  public void setChildren(List<Resource> children) {
    this.children = children;
  }
  
  /*
   * PUBLIC
   */
  
  /*
   * PRIVATE
   */

}
