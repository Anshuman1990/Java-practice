/**
 * 
 */
package com.xml;

import java.util.ArrayList;

/**
 * @author asaha
 *
 */
public class Innings {
private ArrayList<Integer> inningNumber;
private ArrayList<String> team;
private ArrayList<Delivery> delivery = new ArrayList<Delivery>();

public ArrayList<Delivery> getDelivery() {
	return delivery;
}

public void setDelivery(ArrayList<Delivery> delivery) {
	this.delivery = delivery;
}

public ArrayList<Integer> getInningNumber() {
	return inningNumber;
}

public void setInningNumber(ArrayList<Integer> inningNumber) {
	this.inningNumber = inningNumber;
}

public ArrayList<String> getTeam() {
	return team;
}

public void setTeam(ArrayList<String> team) {
	this.team = team;
}
@Override
	public String toString() {
	StringBuffer s_buf = new StringBuffer();
	s_buf.append("Innings Number = "+inningNumber+"\n");
	s_buf.append("Team = "+team+"\n");
	s_buf.append("Deliveries");
	s_buf.append("Numbers of delivery = "+delivery.size()+"\n");
	s_buf.append(delivery.toString()+"\n");
	return s_buf.toString();
	}


}
