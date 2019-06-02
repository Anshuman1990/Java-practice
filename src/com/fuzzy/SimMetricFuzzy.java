package com.fuzzy;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

/**
 * @author ngondkar
 * @version 0.1 
 */

public class SimMetricFuzzy implements Fuzzy 
{
	
	@Override
	public String compare(String str1, String str2, String lb, String ub, String attribute) 
	{
		String status = "";		
		double lbVal = Double.parseDouble(FuzzyConstants.getLowerUpperBounds(lb)); 
		double ubVal = Double.parseDouble(FuzzyConstants.getLowerUpperBounds(ub));
		
		if ((str1 != null && str2==null) || (str1 == null && str2 != null) )
			status = U;
		else
		{
			str1 = str1.toLowerCase();
			str2 = str2.toLowerCase();
			
			str1 = str1.trim();
			str2 = str2.trim();
			
			try
			{
				/*AbstractStringMetric metric = new MongeElkan();
				double result = metric.getSimilarity(str1, str2);*/
				double result = getAlgorithmSimilarity(str1, str2, attribute);
				if(result > ubVal)
					status = T;
				else if(result >= lbVal && result <= ubVal)
					status = P;
				else if(result < lbVal)
					status = F;
			}
			catch(Exception e)
			{
				e.printStackTrace();				}
		}
			
		
		return status;
	}

	@Override
	public String getPercStatus(double perc, String lb, String ub) 
	{
		String status = "";
		double lbVal = Double.parseDouble(FuzzyConstants.getLowerUpperBounds(lb)); 
		double ubVal = Double.parseDouble(FuzzyConstants.getLowerUpperBounds(ub));
		try
		{
			if(perc > ubVal)
				status = T;
			else if(perc >= lbVal && perc <= ubVal)
				status = P;
			else if(perc < lbVal)
				status = F;
		}
		catch(Exception e)
		{
			e.printStackTrace();		}
		return status;
	}
	
	/*** KYP 3.3 - START - Requirement# 100 ***/
	/******************************************/
	@Override
	public String getPercStatusForEntityRes(double perc, String entityResLimit) 
	{
		String status = "";
		double limitVal = Double.parseDouble(FuzzyConstants.getLowerUpperBounds(entityResLimit));
		
		try
		{
			if(perc > limitVal)
				status = T;
			else
				status = F;
		}
		catch(Exception e)
		{
			e.printStackTrace();		}
		return status;
	}
	/*** KYP 3.3 - END   - Requirement# 100 ***/
	/******************************************/
	
	
	/*** KYP 3.3 - START - Requirement# 169 ***/
	/******************************************/
	@Override
	public String getCorporatePercStatus(double perc, String entityResLimit) 
	{
		String status = "";
		double limitVal = Double.parseDouble(FuzzyConstants.getLowerUpperBounds(entityResLimit));
		
		try
		{
			if(perc > limitVal)
				status = T;
			else
				status = F;
		}
		catch(Exception e)
		{
			e.printStackTrace();		}
		return status;
	}
	/*** KYP 3.3 - END   - Requirement# 169 ***/
	/******************************************/
	
	@Override
	public String getPercStatus(double perc, String mb) 
	{
		String status = "";		
		double mbVal = Double.parseDouble(FuzzyConstants.getLowerUpperBounds(mb));		
		try
		{
			if(perc >= mbVal)
				status = P;			
			else if(perc < mbVal)
				status = F;
		}
		catch(Exception e)
		{
			e.printStackTrace();		}
		return status;
	}
	
	/*** KYP 3.3 - END   - Requirement# 100 ***/
	/******************************************/
	
	@Override
	public String getSIPercStatus(double perc, String mb) 
	{
		String status = "";		
		double mbVal = Double.parseDouble(FuzzyConstants.getLowerUpperBounds(mb));		
		try
		{
			if(perc >= mbVal)
				status = T;			
			else if(perc < mbVal)
				status = P;
		}
		catch(Exception e)
		{
			e.printStackTrace();	}
		return status;
	}
	
	@Override
	public double getMatchPercent(String str1, String str2, String attribute) 
	{		
		double result = 0;
		
		if ((str1 != null && str2==null) || (str1 == null && str2 != null) )
			result = 0;
		else
		{			
			str1 = str1.toLowerCase();
			str2 = str2.toLowerCase();
			
			str1 = str1.trim();
			str2 = str2.trim();
			
			try
			{
				/*AbstractStringMetric metric = new MongeElkan();
				result = metric.getSimilarity(str1, str2);	*/
				result = getAlgorithmSimilarity(str1, str2, attribute);
			}
			catch(Exception e)
			{
				e.printStackTrace();			}
		}		
		return result;		
	}
	
	
	/**** METHOD TO APPLY DIFFERENT ALGORITHM FOR DIFFERENT ATTRIBUTES BASED ON PROPERTY VALUES****/
	public double getAlgorithmSimilarity(String str1, String str2, String attribute)
	{
		double result = 0;		
		try
		{
			if(attribute.equals(FuzzyConstants.nameAttr))
			{
				result = loadAlgorithmClass(FuzzyConstants.NAME_ALG, str1, str2);
			}
			else if(attribute.equals(FuzzyConstants.addrAttr))
			{
				result = loadAlgorithmClass(FuzzyConstants.ADDR_ALG, str1, str2);
			}
			else if(attribute.equals(FuzzyConstants.licAttr))
			{
				result = loadAlgorithmClass(FuzzyConstants.LIC_ALG, str1, str2);
			}
			else if(attribute.equals(FuzzyConstants.npiAttr))
			{
				result = loadAlgorithmClass(FuzzyConstants.NPI_ALG, str1, str2);
			}
			else if(attribute.equals(FuzzyConstants.tinAttr))
			{
				result = loadAlgorithmClass(FuzzyConstants.TIN_ALG, str1, str2);
			}
			else if(attribute.equals(FuzzyConstants.deaAttr))
			{
				result = loadAlgorithmClass(FuzzyConstants.DEA_ALG, str1, str2);
			}
			else if(attribute.equals(FuzzyConstants.cliaAttr))
			{
				result = loadAlgorithmClass(FuzzyConstants.CLIA_ALG, str1, str2);
			}
			else if(attribute.equals(FuzzyConstants.phoneAttr))
			{
				result = loadAlgorithmClass(FuzzyConstants.PHONE_ALG, str1, str2);
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();	}
		return result;		
	}
	
	public double loadAlgorithmClass(String algName, String str1, String str2) //throws Exception
	{
		double result = 0;
		try
		{			
			String algProp = FuzzyConstants.getAlgorithm(algName);	
			System.out.println(algProp);
			Class algClass = Class.forName(simmetricClassPath + algProp);				
			Object obj = algClass.newInstance(); 
			AbstractStringMetric metric = (AbstractStringMetric)obj;
			result = metric.getSimilarity(str1, str2);
			return result; 
		}
		catch(Exception e)
		{
			e.printStackTrace();	}
		return result;
	}

}
