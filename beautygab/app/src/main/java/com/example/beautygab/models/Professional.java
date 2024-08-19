package com.example.beautygab.models;

public class Professional {
	private String uid;
	private String name;
	private String firstname;
	private String profession;



	public Professional() {

	}

	public Professional(String uid, String name, String firstname, String profession) {
		this.uid = uid;
		this.name = name;
		this.firstname = firstname;
		this.profession = profession;
	}

	// - GETTERS - //

	public String getUid() { return uid;}
	public String getName() { return name;}
	public String getFirstname() { return firstname;}
	public String getProfession() {return profession;}

	// - SETTERS - //

	public void setUid(String uid) { this.uid = uid;}
	public void setName(String name) { this.name = name;}
	public void setFirstname(String firstname) { this.firstname = firstname;}
	public void setProfession(String profession) {this.profession = profession;}
}
