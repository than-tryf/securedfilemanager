package com.csc.sfm.server.infra.repository;

import java.util.List;

public interface EntityRepository<E> {

  public E get(Integer id);

  public E save(E entity);

  public E update(E entity);

  public void delete(E entity);

  public int count();
  
  public List<E> list();
}
