package com.ust.movieflix.dao;

import org.springframework.data.repository.CrudRepository;

import com.ust.movieflix.model.Movies;

public interface MovieRepo extends CrudRepository<Movies, Integer> 
{
	Movies getById(Integer id);
}
