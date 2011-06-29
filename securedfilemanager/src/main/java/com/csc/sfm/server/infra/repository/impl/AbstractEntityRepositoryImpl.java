package com.csc.sfm.server.infra.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.csc.sfm.server.infra.repository.AbstractEntityRepository;

public abstract class AbstractEntityRepositoryImpl<E> implements AbstractEntityRepository<E> {

  @Autowired
  protected EntityManager em;

  public void save(E entity) {
    em.persist(entity);
    em.flush();
  }

  public void update(E entity) {
    em.merge(entity);
    em.flush();
  }

  public void delete(E entity) {
    em.remove(entity);
    em.flush();
  }

}
