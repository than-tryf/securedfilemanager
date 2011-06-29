package com.csc.sfm.server.infra.repository.impl;

import org.springframework.stereotype.Repository;

import com.csc.sfm.server.domain.Access;
import com.csc.sfm.server.infra.repository.AccessRepository;

@Repository("accessRepository")
public class AccessRepositoryImpl extends AbstractEntityRepositoryImpl<Access> implements AccessRepository {

  public Access getById(int id) {
    return em.find(Access.class, id);
  }

}
