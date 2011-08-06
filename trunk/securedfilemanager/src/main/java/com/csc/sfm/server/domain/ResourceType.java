package com.csc.sfm.server.domain;

public enum ResourceType {

  DIRECTORY("directory"), FILE("file");

  /*
   * ATTRIBUTES
   */
  
  private String styleClass;
  
  /*
   * CONSTRUCTOR
   */
  
  private ResourceType(String styleClass) {
  	this.styleClass = styleClass;
  }
  
  /*
   * PUBLIC
   */
  
  public String getStyleClass() {
  	return this.styleClass;
  }  
  
}
