package com.fes.test.model;

import java.io.Serializable;

public class Test implements Serializable {

	private static final long serialVersionUID = -8034046620680934147L;

	private String id;
	private String name;
	private String pass;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
