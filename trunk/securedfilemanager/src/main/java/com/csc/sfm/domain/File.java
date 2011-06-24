package com.csc.sfm.domain;

public class File extends Resource {

  private FileExtension extension;
  private int size;
  
  /*
   * GETTERS & SETTERS
   */
  
  public FileExtension getExtension() {
    return extension;
  }
  public void setExtension(FileExtension extension) {
    this.extension = extension;
  }

  public int getSize() {
    return size;
  }
  public void setSize(int size) {
    this.size = size;
  }
  
  /*
   * PUBLIC
   */
  
  /*
   * PRIVATE
   */

}
