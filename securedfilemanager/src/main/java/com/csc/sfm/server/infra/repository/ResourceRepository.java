package com.csc.sfm.server.infra.repository;

import java.util.List;

import com.csc.sfm.server.domain.Resource;

public interface ResourceRepository extends EntityRepository<Resource> {
	
	public List<Resource> getRootResources();

	public Resource getResource(Integer id);
	
}
