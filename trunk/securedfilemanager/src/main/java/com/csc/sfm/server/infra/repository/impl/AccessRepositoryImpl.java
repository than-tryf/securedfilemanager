package com.csc.sfm.server.infra.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.csc.sfm.server.domain.Access;
import com.csc.sfm.server.infra.repository.AccessRepository;

@Repository("accessRepository")
public class AccessRepositoryImpl extends AbstractEntityRepositoryImpl<Access> implements AccessRepository {

	@Override
  public Access get(Integer id) {
    return em.find(Access.class, id);
  }

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Access> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
