package com.ust.movieflix.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
//Table for actors
@Entity
public class Actors 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	
	@NotNull
	private String aname;
	
	@JsonManagedReference  //to avoid loop
	@OneToMany(mappedBy = "actor")
	private Set <Movies> movies;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	

	public Set<Movies> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
	
	@Override
	public String toString() {
		return "Actors [aid=" + aid + ", aname=" + aname + "]";
	}

}
