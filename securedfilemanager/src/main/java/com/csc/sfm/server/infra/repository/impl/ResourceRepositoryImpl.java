package com.csc.sfm.server.infra.repository.impl;

import org.springframework.stereotype.Repository;

import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.infra.repository.ResourceRepository;

@Repository("resourceRepository")
public class ResourceRepositoryImpl extends AbstractEntityRepositoryImpl<Resource> implements ResourceRepository {

  public Resource getById(int id) {
    return em.find(Resource.class, id);
  }

}
