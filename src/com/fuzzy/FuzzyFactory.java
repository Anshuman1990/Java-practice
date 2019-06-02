package com.fuzzy;
public class FuzzyFactory 
{	
	private static Fuzzy fuzzyVar = null;	
	
	public Fuzzy getInstance ()
	{		
		if ( fuzzyVar ==null )
		{			
			fuzzyVar = new SimMetricFuzzy();
			return fuzzyVar;
		}
		
		return fuzzyVar;		
	}
}
