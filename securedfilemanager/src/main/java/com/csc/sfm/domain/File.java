package com.csc.sfm.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FILE")
public class File extends Resource {

  private FileExtension extension;
  private int size;
  
  /*
   * GETTERS & SETTERS
   */
  
  @Column(name="EXTENSION")
  public FileExtension getExtension() {
    return extension;
  }
  public void setExtension(FileExtension extension) {
    this.extension = extension;
  }

  @Column(name="SIZE")
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
