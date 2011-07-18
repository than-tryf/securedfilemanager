package com.csc.sfm.server.infra.mapper;

import java.util.List;

import com.csc.sfm.server.domain.AbstractEntity;

public interface EntityMapper<E extends AbstractEntity, V> {

	public V mapToVO(E entity);
	
	public List<V> mapToVO(List<E> entities);
	
	public E mapToEntity(V vo);
	
	public List<E> mapToEntity(List<V> vos);
	
}
