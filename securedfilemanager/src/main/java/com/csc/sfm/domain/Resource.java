package com.csc.sfm.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_RESOURCES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING, length=10)
public abstract class Resource {

  private Integer id;
  private Date creationDate;
  private Date modificationDate;
  private ResourceType type;
  private String name;
  private Resource parent;
  
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
    
  /*
   * PRIVATE
   */

}
