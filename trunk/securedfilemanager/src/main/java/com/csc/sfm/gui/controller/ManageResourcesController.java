package com.csc.sfm.gui.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.csc.sfm.server.application.service.ResourceService;
import com.csc.sfm.server.domain.Resource;

@SessionScoped
@ManagedBean(name="manageResourcesController")
public class ManageResourcesController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*
	 * ATTRIBUTES
	 */

	/**
	 * Resource service
	 */
	@ManagedProperty(value="#{resourceService}")
	private ResourceService resourceService;
	
	/*
	 * CONSTRUCTOR
	 */

	public ManageResourcesController() {
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
	 * @return the list of children resources of the current directory (or root)
	 */
	public List<Resource> getResources() {
		return resourceService.find();
	}
		
}
