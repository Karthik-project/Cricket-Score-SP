package com.example.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.entitys.Match;
import java.util.List;


public interface MatchRepo extends JpaRepository<Match, Integer> {

	Optional<Match> findByTeamHeading(String teamHeading);
}
