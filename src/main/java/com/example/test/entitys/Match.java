package com.example.test.entitys;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cricket_match")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String teamHeading;
	
	private String matchNumVenue;
	
	private String battingTeam;
	
	private String battingTeamScore;
	
	private String bowlTeam;
	
	private String bowlTeamScore;
	

	private String liveText;
	
	private String matchLink;
	
	private String textCompleted;
	
	@Enumerated
	private MatchStatus status;
	
	private  Date date = new Date();

	public Match(int id, String teamHeading, String matchNumVenue, String battingTeam, String battingTeamScore,
			String bowlTeam, String bowlTeamScore, String liveText, String matchLink, String textCompleted,
			MatchStatus status, Date date) {
		super();
		this.id = id;
		this.teamHeading = teamHeading;
		this.matchNumVenue = matchNumVenue;
		this.battingTeam = battingTeam;
		this.battingTeamScore = battingTeamScore;
		this.bowlTeam = bowlTeam;
		this.bowlTeamScore = bowlTeamScore;
		this.liveText = liveText;
		this.matchLink = matchLink;
		this.textCompleted = textCompleted;
		this.status = status;
		this.date = date;
	}

	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setStatus() {
		if(textCompleted.isBlank()) {
			this.status=MatchStatus.Live;
		}
		else {
			this.status=MatchStatus.complete;	
		}
	}

	public String getTeamHeading() {
		return teamHeading;
	}

	public void setTeamHeading(String teamHeading) {
		this.teamHeading = teamHeading;
	}

	public String getMatchNumVenue() {
		return matchNumVenue;
	}

	public void setMatchNumVenue(String matchNumVenue) {
		this.matchNumVenue = matchNumVenue;
	}

	public String getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}

	public String getBattingTeamScore() {
		return battingTeamScore;
	}

	public void setBattingTeamScore(String battingTeamScore) {
		this.battingTeamScore = battingTeamScore;
	}

	public String getBowlTeam() {
		return bowlTeam;
	}

	public void setBowlTeam(String bowlTeam) {
		this.bowlTeam = bowlTeam;
	}

	public String getBowlTeamScore() {
		return bowlTeamScore;
	}

	public void setBowlTeamScore(String bowlTeamScore) {
		this.bowlTeamScore = bowlTeamScore;
	}

	public String getLiveText() {
		return liveText;
	}

	public void setLiveText(String liveText) {
		this.liveText = liveText;
	}

	public String getMatchLink() {
		return matchLink;
	}

	public void setMatchLink(String matchLink) {
		this.matchLink = matchLink;
	}

	public String getTextCompleted() {
		return textCompleted;
	}

	public void setTextCompleted(String textCompleted) {
		this.textCompleted = textCompleted;
	}

	public MatchStatus getStatus() {
		return status;
	}

	public void setStatus(MatchStatus status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	} 
	
	
}

