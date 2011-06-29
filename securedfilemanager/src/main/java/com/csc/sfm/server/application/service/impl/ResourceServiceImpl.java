package com.csc.sfm.server.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.sfm.server.application.exception.NotYetImplementedException;
import com.csc.sfm.server.application.exception.ResourceForbiddenException;
import com.csc.sfm.server.application.exception.ResourceNotFoundException;
import com.csc.sfm.server.application.service.ResourceService;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.infra.repository.ResourceRepository;

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
