package com.csc.sfm.server.infra.repository;

public interface AbstractEntityRepository<E> {

  public E getById(int id);
  public void save(E entity);
  public void update(E entity);
  public void delete(E entity);

}
