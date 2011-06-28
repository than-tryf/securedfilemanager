package com.csc.sfm.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.sfm.application.exception.NotYetImplementedException;
import com.csc.sfm.application.exception.ResourceForbiddenException;
import com.csc.sfm.application.exception.ResourceNotFoundException;
import com.csc.sfm.application.service.ResourceService;
import com.csc.sfm.domain.Resource;
import com.csc.sfm.infra.repository.ResourceRepository;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

  @Autowired
  private ResourceRepository resourceRepository;
  
  /*
   * PUBLIC
   */
  
  @Override
  public Resource getResource(String url)  throws ResourceNotFoundException, ResourceForbiddenException {
    throw new NotYetImplementedException();
  }

  /*
   * PRIVATE
   */
  
}
