package com.csc.sfm.server.application.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csc.sfm.server.application.service.ResourceService;
import com.csc.sfm.server.domain.Directory;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.domain.ResourceType;
import com.csc.sfm.server.infra.repository.ResourceRepository;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
  @Qualifier("resourceRepository")
  private ResourceRepository resourceRepository;
  
  /*
   * PUBLIC
   */
  
	@Override
	public List<Resource> getRootResources() {
		return resourceRepository.getRootResources();
	}
	
  @Override
	@Transactional(readOnly=true)
  public Resource getResource(Integer id) {
  	Resource result = null;
  	if (id != null) {
  		result = resourceRepository.getResource(id);
  		if (result != null && ResourceType.DIRECTORY.equals(result.getType())) {
    		Hibernate.initialize(((Directory) result).getChildren());
  		}
  	}
  	return result;
  }

	@Override
	public List<Resource> find() {
		return resourceRepository.list();
	}
  
  /*
   * PRIVATE
   */

}
