package com.ust.movieflix.dao;

import org.springframework.data.repository.CrudRepository;

import com.ust.movieflix.model.Actors;

public interface ActorRepo extends CrudRepository<Actors, Integer>
{
	Actors getById(Integer id);
}
