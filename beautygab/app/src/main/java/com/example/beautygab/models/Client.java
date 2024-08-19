package com.example.beautygab.models;

public class Client {
	private String uid;
	private String name;
	private String firstname;



	public Client() {

	}

	public Client(String uid, String name, String firstname) {
		this.uid = uid;
		this.name = name;
		this.firstname = firstname;
	}

	// - GETTERS - //

	public String getUid() { return uid;}
	public String getName() { return name;}
	public String getFirstname() { return firstname;}

	// - SETTERS - //

	public void setUid(String uid) { this.uid = uid;}
	public void setName(String name) { this.name = name;}
	public void setFirstname(String firstname) { this.firstname = firstname;}

}
