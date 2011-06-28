package com.csc.sfm.infra.repository.impl;

import org.springframework.stereotype.Repository;

import com.csc.sfm.domain.Resource;
import com.csc.sfm.infra.repository.ResourceRepository;

@Repository("resourceRepository")
public class ResourceRepositoryImpl extends AbstractEntityRepositoryImpl<Resource> implements ResourceRepository {

  public Resource getById(int id) {
    return em.find(Resource.class, id);
  }

}
