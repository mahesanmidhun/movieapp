package com.ust.movieflix.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.movieflix.dao.ActorRepo;
import com.ust.movieflix.exception.ResourceNotFoundException;
import com.ust.movieflix.model.Actors;
import com.ust.movieflix.model.Movies;
import com.ust.movieflix.model.request.ActorRequest;
import com.ust.movieflix.model.response.ActorResponse;




@Service
public class ActorService {
	
	@Autowired
	ActorRepo actorRepository;
	

	
	public ActorResponse addActor(ActorRequest actor) {
		ModelMapper modelMapper = new ModelMapper();
		Actors actors = modelMapper.map(actor, Actors.class);
		ActorResponse actorResponse = modelMapper.map(actorRepository.save(actors), ActorResponse.class);
		return actorResponse;
	}
	
	public List<Actors> findAll(){
		return (List<Actors>) actorRepository.findAll();
		
	}
	
	public Actors findById(Integer id) {
		return actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Actor with id = " + id));
	}
	
	public Actors updateActor(Integer id,Actors actor) {
		actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Actor with id = " + id));
		actor.setAid(id);
		return actorRepository.save(actor);
	}
	
	public Set<Movies> getMoviesbyActor(Integer id){
		Optional<Actors> movieActorRepository = actorRepository.findById(id);
        Actors actor = movieActorRepository.get(); //return actor if present or throws no such element exception
        Set<Movies> movie = actor.getMovies();
        return movie;}
	
    public void deleteActor(Integer id) {
    	actorRepository.findById(id).ifPresent(Actors -> actorRepository.delete(Actors));
    
	}

}
