/**
 * 
 */
package com.xml;

import java.util.ArrayList;

/**
 * @author asaha
 *
 */
public class Info {
private String city;
private String date;
private String match_type;
private String wickets;
private String winner;
private int overs;
private String playerOfMatch;
private ArrayList<String> teams = new ArrayList<String>();
private ArrayList<String> umpires = new ArrayList<String>();

public String getPlayerOfMatch() {
	return playerOfMatch;
}

public void setPlayerOfMatch(String playerOfMatch) {
	this.playerOfMatch = playerOfMatch;
}

public int getOvers() {
	return overs;
}

public void setOvers(int overs) {
	this.overs = overs;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getMatch_type() {
	return match_type;
}

public void setMatch_type(String match_type) {
	this.match_type = match_type;
}

public String getWickets() {
	return wickets;
}

public void setWickets(String wickets) {
	this.wickets = wickets;
}

public String getWinner() {
	return winner;
}

public void setWinner(String winner) {
	this.winner = winner;
}

public ArrayList<String> getTeams() {
	return teams;
}

public void setTeams(ArrayList<String> teams) {
	this.teams = teams;
}

public ArrayList<String> getUmpires() {
	return umpires;
}

public void setUmpires(ArrayList<String> umpires) {
	this.umpires = umpires;
}
/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sBuf = new StringBuffer();
		sBuf.append("City = "+city+"\n");
		sBuf.append("Data= "+date+"\n");
		sBuf.append("Match Type = "+match_type+"\n");
		sBuf.append("Won by = "+wickets+"\n");
		sBuf.append("Winner = "+winner+"\n");
		sBuf.append("Overs= "+overs+"\n");
		sBuf.append("Player Of the Match = "+playerOfMatch+"\n");
		sBuf.append("Teams= "+teams.toString()+"\n");
		sBuf.append("Umpires = "+umpires.toString()+"\n");
		return sBuf.toString();
	}
}
