package com.csc.sfm.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csc.sfm.application.exception.NotYetImplementedException;

@Entity
@Table(name="T_RESOURCES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType = DiscriminatorType.STRING)
public class Resource {

  private Integer id;
  private String name;
  private Resource parent;
  private Date creationDate;
  private Date modificationDate;
  
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

  @Column(name="NAME")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
  @JoinColumn(name="PARENT_ID")
  public Resource getParent() {
    return parent;
  }
  public void setParent(Resource parent) {
    this.parent = parent;
  }
  
  @Column(name="CREATION_DATE")
  public Date getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
  
  @Column(name="MODIFICATION_DATE")
  public Date getModificationDate() {
    return modificationDate;
  }
  public void setModificationDate(Date modificationDate) {
    this.modificationDate = modificationDate;
  }
  
  /*
   * PUBLIC
   */
  
  public String getUrl() {
    // TODO
    throw new NotYetImplementedException();
  }
  
  /*
   * PRIVATE
   */

}
