package com.csc.sfm.server.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("FILE")
public class File extends Resource {

  private FileExtension extension;
  private double size;
  
  /*
   * GETTERS & SETTERS
   */
  
  @Column(name="EXTENSION", length=10, nullable=true)
  @Enumerated(EnumType.STRING)
  public FileExtension getExtension() {
    return extension;
  }
  public void setExtension(FileExtension extension) {
    this.extension = extension;
  }

  @Column(name="SIZE")
  public double getSize() {
    return size;
  }
  public void setSize(double size) {
    this.size = size;
  }
  
  /*
   * PUBLIC
   */
  
  /*
   * PRIVATE
   */

}
