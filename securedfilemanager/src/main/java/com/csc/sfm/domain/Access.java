package com.csc.sfm.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_ACCESSES")
public class Access {

  private Integer id;
  private Date creationDate;
  private Date modificationDate;
  private Resource resource;
  private AccessDurationType durationType;
  private Date startDate;
  private Date endDate;
  private List<Restriction> restrictions;
  
  /*
   * GETTERS & SETTERS
   */

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
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

  @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
  @JoinColumn(name="RESOURCE_ID")
  public Resource getResource() {
    return resource;
  }
  public void setResource(Resource resource) {
    this.resource = resource;
  }
  
  @Column(name="DURATION_TYPE")
  public AccessDurationType getDurationType() {
    return durationType;
  }
  public void setDurationType(AccessDurationType durationType) {
    this.durationType = durationType;
  }
  
  @Column(name="START_DATE")
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  
  @Column(name="END_DATE")
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinTable(
      name="T_RESTRICTIONS",
      joinColumns = @JoinColumn( name="ACCESS_ID"),
      inverseJoinColumns = @JoinColumn( name="ID")
  )
  public List<Restriction> getRestrictions() {
    return restrictions;
  }
  public void setRestrictions(List<Restriction> restrictions) {
    this.restrictions = restrictions;
  }
  
  /*
   * PUBLIC
   */
  
  /*
   * PRIVATE
   */

}
