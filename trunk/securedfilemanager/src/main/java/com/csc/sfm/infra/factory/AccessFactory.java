package com.csc.sfm.infra.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.csc.sfm.domain.Access;
import com.csc.sfm.domain.AccessDurationType;
import com.csc.sfm.domain.Resource;
import com.csc.sfm.domain.Restriction;

public class AccessFactory {

  /*
   * PUBLIC
   */

  public Access newInstance() {
    Date creationDate = GregorianCalendar.getInstance().getTime();
    return newInstance(null, creationDate, creationDate, null, AccessDurationType.PERMANENT, null, null, new ArrayList<Restriction>());
  }
  
  public Access newInstance(Integer id, Date creationDate, Date modificationDate, Resource resource, AccessDurationType durationType, Date startDate, Date endDate, List<Restriction> restrictions) {
    Access access = new Access();
    
    access.setId(id);
    access.setCreationDate(creationDate);
    access.setModificationDate(modificationDate);
    access.setResource(resource);
    access.setDurationType(durationType);
    access.setStartDate(startDate);
    access.setEndDate(endDate);
    access.setRestrictions(restrictions);
    
    return access;
  }
  
}
