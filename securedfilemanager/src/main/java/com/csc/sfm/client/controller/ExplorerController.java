package com.csc.sfm.client.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.csc.sfm.server.application.service.ResourceService;
import com.csc.sfm.server.domain.Directory;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.domain.ResourceType;
import com.csc.sfm.server.infra.factory.ResourceFactory;

@SessionScoped
@ManagedBean(name="explorerController")
public class ExplorerController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*
	 * ATTRIBUTES
	 */

	/**
	 * Resource service
	 */
	@ManagedProperty(value="#{resourceService}")
	private ResourceService resourceService;
	
	/**
	 * The current displayed directory 
	 */
	private Directory currentDirectory;

	/*
	 * CONSTRUCTOR
	 */

	public ExplorerController() {
	}

	/*
	 * GETTERS & SETTERS
	 */
	
	/**
	 * Resource service setter (required for Spring Injection)
	 * 
	 * @param resourceService
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	/*
	 * PUBLIC
	 */

	/**
	 * @return the current directory path
	 */
	public String getCurrentLocation() {
		String path = "/";
		if (currentDirectory != null) {
			path += currentDirectory.getPath();
		}
		return path;		
	}
	
	/**
	 * @return the list of children resources of the current directory (or root)
	 */
	public List<Resource> getResources() {
		if (currentDirectory == null) {
			// The current directory is the root
			return resourceService.getRootResources();
		}
		// 1) Initializes resources list
		List<Resource> resources = new ArrayList<Resource>();

		// 2) Adds parent resource for back link
		Integer parentId = currentDirectory.getParent() != null ? currentDirectory.getParent().getId() : null;
		Directory parent = ResourceFactory.newParentInstance(parentId);
		resources.add(parent);

		// 3) Retrieves and adds the current directory children 
		resources.addAll(currentDirectory.getChildren());
		
		return resources;
	}
	
	/**
	 * Processes the selected resource.
	 * <p>If the resource is a FILE : downloads it.</p>
	 * <p>Else, the resource is a DIRECTORY : displays its children resources.</p>
	 */
	public void processResource() {
		String resourceIdParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("resourceId");
		
		Integer resourceId = null;
		if (resourceIdParam != null && !resourceIdParam.trim().equals("")) {
			// Case of root
			resourceId = Integer.parseInt(resourceIdParam);
		}
		Resource resource = resourceService.getResource(resourceId);
		if (resource != null) {
			if (resource.getType().equals(ResourceType.FILE)) {
				System.out.println("TODO: download file");
			} else {
				currentDirectory = (Directory) resource;
			}
		} else {
			// Displays root
			currentDirectory = null;
		}
	}
	
}
