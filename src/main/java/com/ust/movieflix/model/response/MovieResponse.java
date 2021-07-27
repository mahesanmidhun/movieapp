package com.ust.movieflix.model.response;

import com.ust.movieflix.model.Actors;

public class MovieResponse {

	private String movieName;
	
	private String desctription;
	
	
	private Actors actor;


	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDesctription() {
		return desctription;
	}

	public void setDesctription(String desctription) {
		this.desctription = desctription;
	}

	
	public Actors getActor() {
		return actor;
	}

	public void setActor(Actors actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "Movies [movieName=" + movieName + ", desctription=" + desctription + "]";
	}
	
}


