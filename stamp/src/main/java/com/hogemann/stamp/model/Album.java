package com.hogemann.stamp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@ManyToOne
	private User user;
	
	@OneToMany
	private List<Stamp> stamps;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser(){
		return this.user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public List<Stamp> getStamps() {
		return stamps;
	}

	public void setStamps(List<Stamp> stamps) {
		this.stamps = stamps;
	}
}
