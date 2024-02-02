package com.onemanymapping;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Language {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
@OneToMany(mappedBy="language",cascade=CascadeType.ALL)
private Set<Member> members;
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
public Set<Member> getMembers() {
	return members;
}
public void setMembers(Set<Member> members) {
	this.members = members;
}
@Override
public String toString() {
	return "Language [id=" + id + ", name=" + name + ", members=" + members + ", getId()=" + getId() + ", getName()="
			+ getName() + ", getMembers()=" + getMembers() + "]";
}
public Language(int id, String name, Set<Member> members) {
	super();
	this.id = id;
	this.name = name;
	this.members = members;
}
public Language() {
	
}
}
