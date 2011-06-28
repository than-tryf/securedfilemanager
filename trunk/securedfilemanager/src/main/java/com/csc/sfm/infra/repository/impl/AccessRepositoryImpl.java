package com.csc.sfm.infra.repository.impl;

import org.springframework.stereotype.Repository;

import com.csc.sfm.domain.Access;
import com.csc.sfm.infra.repository.AccessRepository;

@Repository("accessRepository")
public class AccessRepositoryImpl extends AbstractEntityRepositoryImpl<Access> implements AccessRepository {

  public Access getById(int id) {
    return em.find(Access.class, id);
  }

}
