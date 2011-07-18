package com.csc.sfm.client.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.csc.sfm.server.application.exception.ResourceForbiddenException;
import com.csc.sfm.server.application.exception.ResourceNotFoundException;
import com.csc.sfm.server.application.service.ResourceService;
import com.csc.sfm.shared.vo.ResourceVO;

@SessionScoped
@ManagedBean(name="explorerController")
public class ExplorerController {

	private static final String ROOT_PATH = "";
	
	@ManagedProperty(value="#{resourceService}")
	private ResourceService resourceService;
	
	private ResourceVO directory; // The current directory to display

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
	
	public String getResourcePath() {
		String path = "/";
		if (directory != null) {
			path += directory.getPath();
		}
		return path;
	}
	
	public List<ResourceVO> getResources() {
		if (directory == null) {
			try {
				directory = resourceService.getResource(ROOT_PATH);
			} catch (ResourceNotFoundException e) {
				// TODO Manage ResourceNotFoundException
				e.printStackTrace();
			} catch (ResourceForbiddenException e) {
				// TODO Manage ResourceForbiddenException
				e.printStackTrace();
			}
		}
		List<ResourceVO> result = new ArrayList<ResourceVO>();
		result = directory.getChildren();


//		List<ResourceVO> result = new ArrayList<ResourceVO>(directory.getChildren());		
//		Collections.copy(result, directory.getChildren());
		
		return result;
	}
	
}
