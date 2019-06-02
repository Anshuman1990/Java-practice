package com.fuzzy;

/**
 * @author ngondkar
 * @version 0.1 
 */
public interface Fuzzy 
{
	public  double fuzzyLowerBound = 0.60;
	public  double fuzzyUpperBound = 0.95;
	public  String T = "T";
	public  String F = "F";
	public  String U = "U";
	public  String P = "P";
	public  String simmetricClassPath = "uk.ac.shef.wit.simmetrics.similaritymetrics."; 
	
	public String compare (String s1, String s2, String lb, String ub, String attribute);
	
	public double getMatchPercent (String s1, String s2, String attribute);
	
	public String getPercStatus(double perc, String lb, String ub);
	
	public String getPercStatus(double perc, String mb);
	
	//KYP 3.3 - Requirement 170
	public String getSIPercStatus(double perc, String mb);
	
	//KYP 3.3 - Requirement 169
	public String getCorporatePercStatus(double perc, String mb);
	
	//KYP 3.3 - Requirement 100
	public String getPercStatusForEntityRes(double perc, String entityResLimit);

}
