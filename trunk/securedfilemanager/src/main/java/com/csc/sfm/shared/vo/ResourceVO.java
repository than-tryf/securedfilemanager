package com.csc.sfm.shared.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.csc.sfm.server.domain.FileExtension;
import com.csc.sfm.server.domain.ResourceAccessibility;
import com.csc.sfm.server.domain.ResourceType;

public class ResourceVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date creationDate;
	private Date modificationDate;
	private ResourceType type;
	private String name;
	private String path;
	private ResourceAccessibility accessibility;

	// Attributes of Directories
	private List<ResourceVO> children;

	// Attributes of Files
	private FileExtension extension;
	private int size;

	/*
	 * CONSTRUCTORS
	 */

	public ResourceVO() {
	}

	public ResourceVO(String name, ResourceType type, String path, ResourceAccessibility accessibility, List<ResourceVO> children, FileExtension extension, int size) {
		this.creationDate = null;
		this.modificationDate = null;
		this.name = name;
		this.type = type;
		this.path = path;
		this.accessibility = accessibility;
		this.children = children;
		this.extension = extension;
		this.size = size;
	}

	/*
	 * GETTERS & SETTERS
	 */

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ResourceAccessibility getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(ResourceAccessibility accessibility) {
		this.accessibility = accessibility;
	}

	/*
	 * OVERRIDE
	 */

	public List<ResourceVO> getChildren() {
		return children;
	}

	public void setChildren(List<ResourceVO> children) {
		this.children = children;
	}

	public FileExtension getExtension() {
		return extension;
	}

	public void setExtension(FileExtension extension) {
		this.extension = extension;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (o instanceof ResourceVO) {
			ResourceVO r = (ResourceVO) o;
			return this.creationDate.equals(r.getCreationDate())
					&& this.modificationDate.equals(r.getModificationDate())
					&& this.type.equals(r.getType()) 
					&& this.name.equals(r.getName())
					&& this.path.equals(r.getPath())
					&& this.accessibility.equals(r.getAccessibility());
		}
		return false;
	}
	
	/*
	 * PUBLIC
	 */
	
	public String getNameStyle() {
		if (type.equals(ResourceType.DIRECTORY)) {
			return "directory";
		}
		return "file";
	}
}
