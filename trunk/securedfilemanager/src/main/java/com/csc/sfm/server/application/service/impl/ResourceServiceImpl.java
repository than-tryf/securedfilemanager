package com.csc.sfm.server.application.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.csc.sfm.server.application.exception.ResourceForbiddenException;
import com.csc.sfm.server.application.exception.ResourceNotFoundException;
import com.csc.sfm.server.application.service.ResourceService;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.domain.ResourceAccessibility;
import com.csc.sfm.server.domain.ResourceType;
import com.csc.sfm.server.infra.mapper.ResourceMapper;
import com.csc.sfm.server.infra.repository.ResourceRepository;
import com.csc.sfm.shared.vo.ResourceVO;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
  @Qualifier("resourceRepositoryMock")
  private ResourceRepository resourceRepository;
  
  @Autowired
  private ResourceMapper resourceMapper;
  
  /*
   * PUBLIC
   */
  
  @Override
  public ResourceVO getResource(String resourcePath)  throws ResourceNotFoundException, ResourceForbiddenException {
  	ResourceVO result = null;
  	if (resourcePath == null || resourcePath.equals("")) {
  		// Declare Root ResourceVO
  		result = new ResourceVO("", ResourceType.DIRECTORY, "", ResourceAccessibility.OPEN, null, null, 0);

  		// Create Root children ResourceVO
  		List<Resource> rootResources = resourceRepository.getRootResources();
  		List<ResourceVO> children = new ArrayList<ResourceVO>();
  		for (Resource resource : rootResources) {
				children.add(resourceMapper.mapToVO(resource, true));
			}
  		result.setChildren(children);
  	} else {
  		// TODO
  	}
  	return result;
  }

  /*
   * PRIVATE
   */

}
