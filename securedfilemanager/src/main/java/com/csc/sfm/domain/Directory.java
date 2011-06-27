package com.csc.sfm.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

//@Entity
@DiscriminatorValue("DIRECTORY")
public class Directory extends Resource {

  private List<Resource> children;

  /*
   * GETTERS & SETTERS
   */
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  @JoinTable(
      name="T_RESOURCES",
      joinColumns = @JoinColumn( name="RESOURCE_ID"),
      inverseJoinColumns = @JoinColumn( name="ID")
  )
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
