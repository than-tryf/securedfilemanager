package com.csc.sfm.infra.repository.impl;

import com.csc.sfm.domain.Access;
import com.csc.sfm.infra.repository.AccessRepository;

public class AccessRepositoryImpl extends AbstractEntityRepositoryImpl<Access> implements AccessRepository {

  public Access getById(int id) {
    return em.find(Access.class, id);
  }

}
