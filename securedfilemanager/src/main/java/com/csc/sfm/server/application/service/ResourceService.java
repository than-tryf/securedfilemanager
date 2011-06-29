package com.csc.sfm.server.application.service;

import com.csc.sfm.server.application.exception.ResourceForbiddenException;
import com.csc.sfm.server.application.exception.ResourceNotFoundException;
import com.csc.sfm.server.domain.Resource;

public interface ResourceService {

  public Resource getResource(String url) throws ResourceNotFoundException, ResourceForbiddenException;

}
