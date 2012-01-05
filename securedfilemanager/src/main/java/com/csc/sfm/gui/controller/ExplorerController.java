package com.csc.sfm.gui.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private Map<Integer, Boolean> checkedResources;

	/*
	 * CONSTRUCTOR
	 */

	public ExplorerController() {
	  checkedResources = new HashMap<Integer, Boolean>();
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
	
	public Map<Integer, Boolean> getCheckedResources() {
	  return this.checkedResources;
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
			if (resource.getType() == ResourceType.FILE) {
				System.out.println("TODO: download file");
			} else {
				currentDirectory = (Directory) resource;
			}
		} else {
			// Displays root
			currentDirectory = null;
		}
	}
	
	public void submit() {
	  List<Resource> selectedResources = new ArrayList<Resource>();
	  for (Resource resource : getResources()) {
      if (this.checkedResources.get(resource.getId())) {
        selectedResources.add(resource);
      }
    }
	  System.out.println(selectedResources.size() + " resources selected");
	}
		
}
