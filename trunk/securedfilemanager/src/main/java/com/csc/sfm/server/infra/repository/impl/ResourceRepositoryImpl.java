package com.csc.sfm.server.infra.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.infra.repository.ResourceRepository;

@Repository("resourceRepository")
public class ResourceRepositoryImpl extends AbstractEntityRepositoryImpl<Resource> implements ResourceRepository {

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
    return em.createNamedQuery("listResources").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getRootResources() {
		return em.createNamedQuery("getRootResources").getResultList();
	}
	
}
