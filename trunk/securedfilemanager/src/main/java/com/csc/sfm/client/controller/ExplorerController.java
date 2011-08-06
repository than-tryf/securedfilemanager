package com.csc.sfm.client.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.csc.sfm.server.application.service.ResourceService;
import com.csc.sfm.server.domain.Directory;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.domain.ResourceType;

@SessionScoped
@ManagedBean(name="explorerController")
public class ExplorerController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*
	 * ATTRIBUTES
	 */

	@ManagedProperty(value="#{resourceService}")
	private ResourceService resourceService;
	
	private Directory currentDirectory; // The current directory to display

	public ExplorerController() {
	}

	/*
	 * GETTERS & SETTERS
	 */
	
	// Required for Spring Injection
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	/*
	 * PUBLIC
	 */

	/**
	 * 
	 * @return
	 */
	public String getResourcePath() {
		String path = "/";
		if (currentDirectory != null) {
			path += currentDirectory.getPath();
		}
		return path;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Resource> getResources() {
		if (currentDirectory == null) {
			return resourceService.getRootResources();
		}
		return currentDirectory.getChildren();
	}
	
	/**
	 * 
	 */
	public void processResource() {
		Integer resourceId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("resourceId"));
		Resource resource = resourceService.getResource(resourceId);
		if (resource != null) {
			if (resource.getType().equals(ResourceType.FILE)) {
				System.out.println("TODO: download file");
			} else {
				currentDirectory = (Directory) resource;
			}
		} else {
			System.err.println("file not found");
		}
	}
	
}
