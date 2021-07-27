package com.ust.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.movieflix.dao.MovieRepo;
import com.ust.movieflix.exception.ResourceNotFoundException;
import com.ust.movieflix.model.Movies;

@Service
public class MovieService {
	
	@Autowired
	MovieRepo movieRepository;
	
	
	public Movies addMovie(Movies movie) {
		return movieRepository.save(movie);
	}
	
	public List<Movies> getAllMovies(){
		return (List<Movies>) movieRepository.findAll();
	}
	
	public Movies findById(Integer id) {
		return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Movie with id = " + id));
	}
	
	public void deleteMovie(int id) {
		movieRepository.deleteById(id);
	}
}
