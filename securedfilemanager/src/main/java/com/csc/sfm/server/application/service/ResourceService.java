package com.csc.sfm.server.application.service;

import java.util.List;

import com.csc.sfm.server.domain.Resource;

public interface ResourceService {

	public List<Resource> getRootResources();
	
  public Resource getResource(Integer id);

  public List<Resource> find();

}
