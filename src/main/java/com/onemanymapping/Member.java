package com.onemanymapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Member {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private String gender;
@ManyToOne
@JoinColumn(name="language_id")
private Language language;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Language getLanguage() {
	return language;
}
public void setLanguage(Language language) {
	this.language = language;
}
@Override
public String toString() {
	return "Member [id=" + id + ", name=" + name + ", gender=" + gender + ", language=" + language + ", getId()="
			+ getId() + ", getName()=" + getName() + ", getGender()=" + getGender() + ", getLanguage()=" + getLanguage()
			+ "]";
}
public Member(int id, String name, String gender, Language language) {
	super();
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.language = language;
}
public Member() {
	
}
}
