package com.csc.sfm.server.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="T_ACCESSES")
public class Access extends AbstractEntity {

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

  @Transient
  @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
  @JoinColumn(name="RESOURCE_ID", nullable=false)
  public Resource getResource() {
    return resource;
  }
  public void setResource(Resource resource) {
    this.resource = resource;
  }
  
  @Column(name="DURATION_TYPE", nullable=false)
  @Enumerated(EnumType.ORDINAL)
  public AccessDurationType getDurationType() {
    return durationType;
  }
  public void setDurationType(AccessDurationType durationType) {
    this.durationType = durationType;
  }
  
  @Column(name="START_DATE", nullable=true)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  
  @Column(name="END_DATE", nullable=true)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
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
