package com.csc.sfm.server.infra.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.csc.sfm.server.domain.Access;
import com.csc.sfm.server.domain.AccessDurationType;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.domain.Restriction;

@Component
@Scope("singleton")
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
