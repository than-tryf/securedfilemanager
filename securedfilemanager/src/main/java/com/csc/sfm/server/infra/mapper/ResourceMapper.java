package com.csc.sfm.server.infra.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.csc.sfm.server.domain.Directory;
import com.csc.sfm.server.domain.File;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.domain.ResourceType;
import com.csc.sfm.shared.vo.ResourceVO;

@Component
public class ResourceMapper implements EntityMapper<Resource, ResourceVO> {

	@Override
	public ResourceVO mapToVO(Resource entity) {
		return mapToVO(entity, false);
	}

	public ResourceVO mapToVO(Resource entity, boolean mapChildren) {
		ResourceVO result = null;
		if (entity != null) {
			result = new ResourceVO();
			
			result.setCreationDate(entity.getCreationDate());
			result.setModificationDate(entity.getModificationDate());
			result.setType(entity.getType());
			result.setName(entity.getName());
			result.setPath(entity.getPath());
			result.setAccessibility(entity.getAccessibility());
			
			if (result.getType().equals(ResourceType.DIRECTORY)) {
				List<ResourceVO> children = new ArrayList<ResourceVO>();
				if (mapChildren) {
					Directory dir = (Directory) entity;
					for (Resource resource : dir.getChildren()) {
						children.add(mapToVO(resource));
					}
				}
				result.setChildren(children);				
			} else { // ResourceType.FILE
				File file = (File) entity;
				result.setSize(file.getSize());
				result.setExtension(file.getExtension());
			}
		}
		return result;
	}
	
	@Override
	public List<ResourceVO> mapToVO(List<Resource> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource mapToEntity(ResourceVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> mapToEntity(List<ResourceVO> vos) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
