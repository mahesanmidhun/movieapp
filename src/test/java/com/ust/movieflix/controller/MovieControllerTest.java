package com.ust.movieflix.controller;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ust.movieflix.model.Actors;
import com.ust.movieflix.model.Movies;
import com.ust.movieflix.model.request.MovieRequest;
import com.ust.movieflix.model.response.MovieResponse;
import com.ust.movieflix.service.MovieService;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest(classes= {MovieController.class})
public class MovieControllerTest {

	@Autowired
	MovieController controller;
	
	
	@MockBean
	MovieService service;
	
	static MovieRequest request;
	static MovieResponse response;
	static Movies movie;
	static Actors actor;
	
	@BeforeAll
	static void setUp() {
		movie = new Movies();
		movie.setId(2);
		movie.setMovieName("Lucifer");
		movie.setDesctription("Thriller");
		movie.setActor(actor);	
	}
	
	@Test
	public void addMovieTest() {
		when(service.addMovie(movie)).thenReturn(movie);
		Assert.assertEquals(controller.addMovie(movie).getBody(), movie);
	}
	
	@Test
	public void getAllMoviesTest() {
		List<Movies> movies = new ArrayList<Movies>();
		movies.add(movie);
		when(service.getAllMovies()).thenReturn(movies);
		Assert.assertEquals(controller.getAllMovies().getBody(), movies);
	}
	
	@Test
	public void deleteMovieTest() {
	service.deleteMovie(1);
	Assert.assertEquals(controller.deleteMovie(1).getBody(), "Deleted successfully...!" );

	}
	
	
}
