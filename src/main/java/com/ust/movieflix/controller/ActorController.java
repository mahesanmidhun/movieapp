package com.ust.movieflix.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.ust.movieflix.model.Actors;
import com.ust.movieflix.model.Movies;
import com.ust.movieflix.model.request.ActorRequest;
import com.ust.movieflix.model.response.ActorResponse;
import com.ust.movieflix.service.ActorService;


/*
 * Controller class for Actors class to handle end-point request and perform crud operations
 */
@RestController
public class ActorController {
	//Auto wiring to repository of actor
	@Autowired
	private ActorService service;
	
	
	
	//Default view for the application
	@GetMapping("/")
	String greeting() {
		return "Hello There!";
	}
	

	//Adding an actor
		@PostMapping("/actor")
	    public ResponseEntity<?> addActor(@Valid @RequestBody ActorRequest actor){	
	        ActorResponse savedActor = service.addActor(actor);
	        // return new ResponseEntity<> ((list, responseHeaders, HttpStatus.OK);
	        return ResponseEntity.ok().body(savedActor);
	    }
		
    /*Get all actors with method findAll */
    @GetMapping("/actor/all")
    public ResponseEntity<List<Actors>> getAllActors() {
    	return new ResponseEntity<List<Actors>>(service.findAll(), HttpStatus.OK);
        
    }

    /*Get actor by first checking if given id exists, if not, return message with actor was not found */
    @GetMapping("/actor/{id}")
    ResponseEntity<Actors> getActorById(@Valid @PathVariable("id")  Integer id) {

     Actors actor = service.findById(id);
     return new ResponseEntity<Actors>(actor, HttpStatus.OK);
        

    }
 
    // To update the details of actor
    @PutMapping("/actor/{id}")
    public ResponseEntity<Actors> updateActor(@Valid @RequestBody Actors updatedActor,
                                                      @PathVariable ("id")  Integer id){
    	
    	Actors actor = service.updateActor(id,updatedActor);
    	return new ResponseEntity<Actors>(actor, HttpStatus.OK);
    }
    //Method to fetch all the movies that the actor has acted in
    @GetMapping("/actor/{id}/movies")
    public ResponseEntity<Set<Movies>> getMoviesByActor(@Valid @PathVariable("id") Integer id){

            Set<Movies> moviesByActor = service.getMoviesbyActor(id);
        return new ResponseEntity<Set<Movies>>(moviesByActor, HttpStatus.OK);
    }

    /*Delete actor by checking first if the given id exists, if not, return a message and HttpStatus not found*/
    @DeleteMapping("/actor/{id}")
    public ResponseEntity<?> deleteActor(@Valid @PathVariable ("id") Integer id){

        service.deleteActor(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
