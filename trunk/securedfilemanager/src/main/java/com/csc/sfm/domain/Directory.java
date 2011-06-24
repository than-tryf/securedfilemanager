package com.csc.sfm.domain;

import java.util.List;

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
