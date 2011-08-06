package com.csc.sfm.server.infra.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.csc.sfm.server.domain.Directory;
import com.csc.sfm.server.domain.File;
import com.csc.sfm.server.domain.FileExtension;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.domain.ResourceAccessibility;
import com.csc.sfm.server.domain.ResourceType;
import com.csc.sfm.server.infra.repository.ResourceRepository;

@Repository("resourceRepositoryMock")
public class ResourceRepositoryMock implements ResourceRepository, Serializable {

	private static final long serialVersionUID = 1L;

	private Integer index = 1;
	private List<Resource> entities = new ArrayList<Resource>();

	public ResourceRepositoryMock() {
		Directory dirSpring = new Directory();
		dirSpring.setName("Spring");
		dirSpring.setType(ResourceType.DIRECTORY);
		dirSpring.setParent(null);
		dirSpring.setAccessibility(ResourceAccessibility.OPEN);
		dirSpring.setChildren(new ArrayList<Resource>());
		save(dirSpring);
		
		Directory dirJsf = new Directory();
		dirJsf.setName("JSF");
		dirJsf.setType(ResourceType.DIRECTORY);
		dirJsf.setParent(null);
		dirJsf.setAccessibility(ResourceAccessibility.OPEN);
		dirJsf.setChildren(new ArrayList<Resource>());
		save(dirJsf);
				
		File fileToto = new File();
		fileToto.setName("Toto.xml");
		fileToto.setType(ResourceType.FILE);
		fileToto.setParent(null);
		fileToto.setAccessibility(ResourceAccessibility.OPEN);
		fileToto.setExtension(FileExtension.XML);
		fileToto.setSize(123);
		save(fileToto);

		File fileTata = new File();
		fileTata.setName("Tata.txt");
		fileTata.setType(ResourceType.FILE);
		fileTata.setParent(null);
		fileTata.setAccessibility(ResourceAccessibility.OPEN);
		fileTata.setExtension(FileExtension.TXT);
		fileTata.setSize(2097152);
		save(fileTata);
	}
	
	@Override
  public Resource get(Integer id) {
		if (id != null) {
			for (Resource entity : entities) {
				if (entity.getId().equals(id)) {
					return entity;
				}
			}
		}
		return null;
  }

	@Override
	public int count() {
		return entities.size();
	}

	@Override
	public List<Resource> list() {
		return entities;
	}

	@Override
	public List<Resource> getRootResources() {
		List<Resource> result = new ArrayList<Resource>();
		for (Resource entity : entities) {
			if (entity.getParent() == null) {
				result.add(entity);
			}
		}
		return result;
	}
	
	@Override
  public Resource save(Resource entity) {
		if (entity != null && get(entity.getId()) == null) {
			if (entity.getId() == null) {
				entity.setId(new Integer(index++));
			}
			entities.add(entity);
			return entity;
		}
		return null;
  }

	@Override
  public Resource update(Resource entity) {
		if (entity != null && entity.getId() != null) {
			Resource old = get(entity.getId());
			if (old != null) {
				old = entity;
				return entity;
			}
		}
		return null;
  }

	@Override
  public void delete(Resource entity) {
		if (entity != null) {
			Resource persisted = get(entity.getId());
			if (persisted != null) {
				entities.remove(persisted);
			}
		}
  }

	@Override
	public Resource getResource(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
