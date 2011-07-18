package com.csc.sfm.server.application.service;

import com.csc.sfm.server.application.exception.ResourceForbiddenException;
import com.csc.sfm.server.application.exception.ResourceNotFoundException;
import com.csc.sfm.shared.vo.ResourceVO;

public interface ResourceService {

  public ResourceVO getResource(String url) throws ResourceNotFoundException, ResourceForbiddenException;

}
