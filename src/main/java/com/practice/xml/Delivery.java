/**
 * 
 */
package com.practice.xml;

import java.util.HashMap;

/**
 * @author asaha
 *
 */
public class Delivery {
private int over;
private int ball;
private String batsman;
private String bowler;
private String non_striker;
private HashMap<String , String> runs = new HashMap<String,String>();
private HashMap<String, String> wickets = new HashMap<String,String>();

public int getOver() {
	return over;
}

public void setOver(int over) {
	this.over = over;
}

public HashMap<String, String> getWickets() {
	return wickets;
}

public void setWickets(HashMap<String, String> wickets) {
	this.wickets = wickets;
}

public int getBall() {
	return ball;
}

public void setBall(int ball) {
	this.ball = ball;
}

public String getBatsman() {
	return batsman;
}

public void setBatsman(String batsman) {
	this.batsman = batsman;
}

public String getBowler() {
	return bowler;
}

public void setBowler(String bowler) {
	this.bowler = bowler;
}

public String getNon_striker() {
	return non_striker;
}

public void setNon_striker(String non_striker) {
	this.non_striker = non_striker;
}

public HashMap<String, String> getRuns() {
	return runs;
}

public void setRuns(HashMap<String, String> runs) {
	this.runs = runs;
}
@Override
	public String toString() {
		StringBuffer s_buf = new StringBuffer();
		s_buf.append("Over = "+over+"\n");
		s_buf.append("Ball = "+ball+"\n");
		s_buf.append("BatsMan = "+batsman+"\n");
		s_buf.append("Bowler = "+bowler+"\n");
		s_buf.append("Non Striker = "+non_striker+"\n");
		s_buf.append("Runs Scored = "+runs.toString()+"\n");
		if(!wickets.isEmpty()){
			s_buf.append("Wickets = "+wickets.toString());
		}
		else{
			s_buf.append("NO WICKETS TAKEN");
		}
		s_buf.append("\n");
		return s_buf.toString();
	}

}
