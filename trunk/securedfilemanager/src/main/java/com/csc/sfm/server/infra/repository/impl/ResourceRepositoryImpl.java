package com.csc.sfm.server.infra.repository.impl;

import static com.csc.sfm.server.infra.repository.impl.ResourceRepositoryImpl.KEY;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.csc.sfm.server.domain.Directory;
import com.csc.sfm.server.domain.File;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.infra.repository.ResourceRepository;

@Repository(KEY)
public class ResourceRepositoryImpl extends BaseEntityRepositoryImpl<Resource> implements ResourceRepository {

	public final static String KEY = "resourceRepository";
	
	@Override
  public Resource get(Integer id) {
    return em.find(Resource.class, id);
  }

	@Override
	public int count() {
		return list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> list() {
    return em.createNamedQuery(Resource.LIST_RESOURCES).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getRootResources() {
		return em.createNamedQuery(Resource.GET_ROOT_RESOURCES).getResultList();
	}
	
	@Override
	public Resource getResource(Integer id) {
		return em.find(Resource.class, id);
	}
	
	@Override
	public File getFile(Integer id) {
		return em.find(File.class, id);
	}
	
	@Override
	public Directory getDirectory(Integer id) {
		return em.find(Directory.class, id);
	}
	
}
