package com.ust.movieflix.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

//Table for movies
@Entity
public class Movies {
	
	@Id
	@NotNull
	private Integer Id;
	
	@NotNull
	private String movieName;
	
	private String desctription;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "aid") //foreign key
	private Actors actor;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

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
		return "Movies [Id=" + Id + ", movieName=" + movieName + ", desctription=" + desctription + "]";
	}
	
}
