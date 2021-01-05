package com.team.service;

import com.team.service.Status;

public class Status {
	private final String NAME;

	public Status(String NAME) {
		super();
		this.NAME = NAME;
	}
	
	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VOCATION");
	
	

	public String getNAME() {
		return NAME;
	}



	@Override
	public String toString() {
		return  NAME ;
	}
	
	
	
	

}
