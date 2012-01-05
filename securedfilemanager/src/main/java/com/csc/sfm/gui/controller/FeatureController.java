package com.csc.sfm.gui.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="featureController")
public class FeatureController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*
	 * FEATURES
	 */

	/**
	 * 
	 */
	private boolean globalSearch = true;
	
	/**
	 * 
	 */
	private boolean userAuthentication = true;
	
	/*
	 * GETTERS
	 */
	
	public boolean getGlobalSearchActivated() {
		return globalSearch;
	}
	
	public boolean getUserAuthenticationActivated() {
		return userAuthentication;
	}

}
