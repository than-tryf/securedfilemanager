package com.csc.sfm.application.service;

import com.csc.sfm.application.exception.ResourceForbiddenException;
import com.csc.sfm.application.exception.ResourceNotFoundException;
import com.csc.sfm.domain.Resource;

public interface ResourceService {

  public Resource getResource(String url) throws ResourceNotFoundException, ResourceForbiddenException;

}
