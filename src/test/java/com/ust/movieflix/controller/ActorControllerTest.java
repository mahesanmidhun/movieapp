package com.ust.movieflix.controller;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.ust.movieflix.model.Actors;
import com.ust.movieflix.model.request.ActorRequest;
import com.ust.movieflix.model.response.ActorResponse;
import com.ust.movieflix.service.ActorService;

@SpringBootTest(classes= {ActorController.class})
public class ActorControllerTest {
	
	@Autowired
	ActorController controller;

	@MockBean
	ActorService service;
	
	static ActorRequest actorRequest;
	static ActorResponse actorResponse;
	static Actors actor;
	
	@BeforeAll
	static void setUp() {

		//for request
		actorRequest = new ActorRequest();
		actorRequest.setAname("Mohanlal");
		
		//for response
		actorResponse = new ActorResponse();
		actorResponse.setAname("Mohanlal");
		
	
		
		//for model
		actor = new Actors();
		actor.setAid(1);
		actor.setAname("Mohanlal");
		
	}
	
	@Test
	public void addActorTest(){
		when(service.addActor(actorRequest)).thenReturn(actorResponse);
		Assert.assertEquals(controller.addActor(actorRequest).getBody(), actorResponse);
	}
	
	@Test
	public void getAllActorsTest() {
		List<Actors> actors = new ArrayList<Actors>();
		actors.add(actor);
		when(service.findAll()).thenReturn(actors);
		Assert.assertEquals(controller.getAllActors().getBody(), actors);
	}
	
	@Test
	public void getActorByIdTest() {
		when(service.findById(1)).thenReturn(actor);
		Assert.assertEquals(controller.getActorById(1).getBody(), actor);
	}

	@Test
	public void updateActorTest() {
		when(service.updateActor(1, actor)).thenReturn(actor);
		Assert.assertEquals(controller.updateActor(actor, 1).getBody(), actor);
	}
	
	@Test
	public void deleteActorTest() {
	Assert.assertEquals(controller.deleteActor(1).getBody(), "Deleted successfully...!");
	}
	
}
