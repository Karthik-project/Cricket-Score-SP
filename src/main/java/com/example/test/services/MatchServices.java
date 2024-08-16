package com.example.test.services;

import java.util.*;


import com.example.test.entitys.Match;

public interface MatchServices {

	//all matches
	List<Match> getAllMatches();
	
	// live matches
	List<Match> getLiveMatches();
	
	// points table
	List<Map<String,String>> getPointsTable();
}
