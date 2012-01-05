package com.csc.sfm.gui.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.csc.sfm.server.application.service.ConnectionService;
import com.csc.sfm.server.domain.User;

@SessionScoped
@ManagedBean(name = "applicationController")
public class ApplicationController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*
	 * ATTRIBUTES
	 */
	
	/**
	 * Binded property for "username" text input
	 */
	private String username;

	/**
	 * Binded property for "password" text input
	 */
	private String password;

	/**
	 * Connected user 
	 */
	private User user;
	
	/**
	 * Connection service
	 */
	@ManagedProperty(value="#{connectionService}")
	private ConnectionService connectionService;
	
	/*
	 * GETTERS & SETTERS
	 */

	/**
	 * Resource service setter (required for Spring Injection)
	 * 
	 * @param resourceService
	 */
	public void setConnectionService(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/*
	 * PUBLIC
	 */

	public boolean getUserConnected() {
		return user != null;
	}
	
	public void connectUser() {
		user = connectionService.connect(username, password);
	}
	
	public void disconnectUser() {
		user = null;
	}
	
}
