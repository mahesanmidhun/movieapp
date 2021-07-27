package com.ust.movieflix.model.response;

import java.util.Set;

import com.ust.movieflix.model.Movies;

public class ActorResponse {

	private String aname;
	

	private Set <Movies> movies;
	

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
		return "Actors [aname=" + aname + "]";
	}

}
