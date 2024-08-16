package com.example.test.services.imp;

import java.io.IOException;
import java.util.*;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.test.entitys.Match;
import com.example.test.repository.MatchRepo;
import com.example.test.services.MatchServices;
@Service
public class MatchServiceImpl implements MatchServices {

	@Autowired
	private MatchRepo matchrepo;
	
		
	public MatchServiceImpl(MatchRepo matchrepo) {
		super();
		this.matchrepo = matchrepo;
	}

	@Override
	public List<Match> getAllMatches() {
		
		return this.matchrepo.findAll();
	}

	@Override
	public List<Match> getLiveMatches() {
		 List<Match> matches = new ArrayList<>();
	        try {
	            String url = "https://www.cricbuzz.com/cricket-match/live-scores";
	            Document document = (Document) Jsoup.connect(url).get();
	            org.jsoup.select.Elements liveScoreElements = ((Element) document).select("div.cb-mtch-lst.cb-tms-itm");
	            for (Element match : liveScoreElements) {
	                HashMap<String, String> liveMatchInfo = new LinkedHashMap<>();
	                String teamsHeading = match.select("h3.cb-lv-scr-mtch-hdr").select("a").text();
	                String matchNumberVenue = match.select("span").text();
	                Elements matchBatTeamInfo = (Elements) match.select("div.cb-hmscg-bat-txt");
	                String battingTeam = ((Element) matchBatTeamInfo).select("div.cb-hmscg-tm-nm").text();
	                String score = ((Element) matchBatTeamInfo).select("div.cb-hmscg-tm-nm+div").text();
	                Elements bowlTeamInfo = (Elements) match.select("div.cb-hmscg-bwl-txt");
	                String bowlTeam = ((Element) bowlTeamInfo).select("div.cb-hmscg-tm-nm").text();
	                String bowlTeamScore = ((Element) bowlTeamInfo).select("div.cb-hmscg-tm-nm+div").text();
	                String textLive = match.select("div.cb-text-live").text();
	                String textComplete = match.select("div.cb-text-complete").text();
	                //getting match link
	                String matchLink = match.select("a.cb-lv-scrs-well.cb-lv-scrs-well-live").attr("href").toString();

	                Match match1 = new Match();
	                match1.setTeamHeading(teamsHeading);
	                match1.setMatchNumVenue(matchNumberVenue);
	                match1.setBattingTeam(battingTeam);
	                match1.setBattingTeamScore(score);
	                match1.setBowlTeam(bowlTeam);
	                match1.setBowlTeamScore(bowlTeamScore);
	                match1.setLiveText(textLive);
	                match1.setMatchLink(matchLink);
	                match1.setTextCompleted(textComplete);
	                match1.setStatus();


	                matches.add(match1);

//	                update the match in database


	                updateMatch(match1);
	                
	                updateMatchInDb(match1)
	                


	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return matches;
	}

	private void updateMatchInDb(Match match1) {

		this.matchrepo.findByTeamHeading(this,match1.getTeamHeading())
	}

	@Override
	public List<Map<String, String>> getPointsTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
