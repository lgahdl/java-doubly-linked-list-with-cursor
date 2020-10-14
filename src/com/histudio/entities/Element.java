package com.histudio.entities;

public class Element {

	private String key;

	private String name;

	public Element(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return this.key;
	}

}
