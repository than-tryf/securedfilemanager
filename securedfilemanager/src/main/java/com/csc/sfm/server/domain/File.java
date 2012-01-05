package com.csc.sfm.server.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

import com.csc.sfm.server.infra.util.SizeFormatter;

@Entity
@DiscriminatorValue("FILE")
public class File extends Resource {

  private FileExtension extension;
  private double size;
  private String contentType;
  private String uri;
  
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

  @Column(name="CONTENTTYPE")
  public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
 
	@Column(name="URI")
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
  /*
   * PUBLIC
   */
  
	@Transient
  public String getFormattedSize() {
  	return SizeFormatter.format(size);
  }
  
  /*
   * PRIVATE
   */

}
