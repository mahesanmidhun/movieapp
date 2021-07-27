package com.ust.movieflix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ust.movieflix.model.Movies;
import com.ust.movieflix.service.MovieService;

/*
 * Controller class for Movies class to handle end-point request and perform crud operation
 */
@RestController
public class MovieController 
{

	@Autowired
	MovieService service;
	
	
	
	//Adding a movie
	@PostMapping("/movie")
    public ResponseEntity<?> addMovie(@Valid @RequestBody Movies movie){	
        Movies savedMovie = service.addMovie(movie);
        return ResponseEntity.ok().body(savedMovie);
    }
	
	//Fetch all movies
    @GetMapping("/movie/all")
    public ResponseEntity<List<?>> getAllMovies() {
    	List<?> list = service.getAllMovies();      
        return ResponseEntity.ok().body(list);
    }
    
    //Delete movie
    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovie(@Valid @PathVariable ("id") Integer id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }



}
