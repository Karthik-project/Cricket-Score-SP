package com.example.test.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.entitys.Match;
import com.example.test.services.MatchServices;

@RestController
@RequestMapping("/match")
public class MatchController {

	@Autowired
	public MatchServices matchService;
	
	
	public MatchController(MatchServices matchService) {
		super();
		this.matchService = matchService;
	}


	@GetMapping("/live")
	public ResponseEntity<List<Match>> getLiveMatches(){
		
		return new ResponseEntity<>(this.matchService.getLiveMatches(),HttpStatus.OK);
	}
}
