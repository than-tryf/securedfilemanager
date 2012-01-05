package com.csc.sfm.server.infra.repository;

import java.util.List;

import com.csc.sfm.server.domain.Directory;
import com.csc.sfm.server.domain.File;
import com.csc.sfm.server.domain.Resource;

public interface ResourceRepository extends EntityRepository<Resource> {
	
	public List<Resource> getRootResources();

	public Resource getResource(Integer id);
	
	public File getFile(Integer id);
	
	public Directory getDirectory(Integer id);
}
