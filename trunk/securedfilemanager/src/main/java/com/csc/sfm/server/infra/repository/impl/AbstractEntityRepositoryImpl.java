package com.csc.sfm.server.infra.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractEntityRepositoryImpl<E> {

  @Autowired
  protected EntityManager em;

  public E save(E entity) {
    em.persist(entity);
    em.flush();
    return entity;
  }

  public E update(E entity) {
    em.merge(entity);
    em.flush();
    return entity;
  }

  public void delete(E entity) {
    em.remove(entity);
    em.flush();
  }

}
