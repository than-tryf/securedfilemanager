package com.csc.sfm.server.domain;

import static com.csc.sfm.server.domain.Resource.GET_ROOT_RESOURCES;
import static com.csc.sfm.server.domain.Resource.LIST_RESOURCES;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="T_RESOURCES")
@NamedQueries({
  @NamedQuery(name=GET_ROOT_RESOURCES, query="SELECT r FROM Resource r WHERE r.parent IS NULL"),
  @NamedQuery(name=LIST_RESOURCES, query="SELECT r FROM Resource r")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING, length=10)
public abstract class Resource extends BaseEntity {

	/*
	 * CONST
	 */
	
	public static final String GET_ROOT_RESOURCES = "getRootResources";
	public static final String LIST_RESOURCES = "listResources";
	
	/*
	 * ATTRIBUTES
	 */
	
  private Date creationDate;
  private Date modificationDate;
  private ResourceType type;
  private String name;
  private ResourceAccessibility accessibility;
  private Resource parent;

  /*
   * GETTERS & SETTERS
   */
  
  @Column(name="CREATION_DATE", nullable=true)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
  
  @Column(name="MODIFICATION_DATE", nullable=true)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getModificationDate() {
    return modificationDate;
  }
  public void setModificationDate(Date modificationDate) {
    this.modificationDate = modificationDate;
  }
  
  @Column(name="TYPE", nullable=false, insertable=false, updatable=false)
  @Enumerated(EnumType.STRING)
  public ResourceType getType() {
    return type;
  }
  public void setType(ResourceType type) {
    this.type = type;
  }

  @Column(name="NAME", nullable=false)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  @Column(name="ACCESSIBILITY", nullable=false, insertable=false, updatable=false)
  @Enumerated(EnumType.STRING)
  public ResourceAccessibility getAccessibility() {
    return accessibility;
  }
  public void setAccessibility(ResourceAccessibility accessibility) {
    this.accessibility = accessibility;
  }

  @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
  @JoinColumn(name="PARENT_ID", nullable=true)
  public Resource getParent() {
    return parent;
  }
  public void setParent(Resource parent) {
    this.parent = parent;
  }

  /*
   * PUBLIC
   */

  @Transient
  public String getStyleClass() {
  	return this.type.getStyleClass();
  }
  
  @Transient
  public String getPath() {
  	String result = "";
  	if (parent != null) {
  		result = parent.getPath();
  	}
  	result += name + "/";
  	return result;
  }
  
  @Transient
  public String getFormattedModificationDate() {
  	if (modificationDate != null) {
  		DateFormat df = new SimpleDateFormat("dd-MM-yyyy:hh'h'mm");
  		return df.format(modificationDate);
  	}
  	return "";
  }
  
  @Transient
  public boolean getIsFile() {
  	return ResourceType.FILE == type;
  }
  
  @Transient
  public boolean getIsDirectory() {
  	return ResourceType.DIRECTORY == type;
  }
  
  @Transient
  public boolean getIsParent() {
    return ResourceType.PARENT == type;
  }
  
  /*
   * PRIVATE
   */

}
