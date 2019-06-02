package com.fuzzy;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;
/**
 * @author ngondkar
 * @version 0.1 
 */
public class FuzzyConstants {
	public static final String nameAttr = "NAME";
	public static final String addrAttr = "ADDRESS";
	public static final String licAttr = "LICENSE";
	public static final String npiAttr = "NPI";	
	public static final String ssnAttr = "SSN";
	public static final String tinAttr = "TIN";
	public static final String deaAttr = "DEA";
	public static final String cliaAttr = "CLIA";	
	
	/*Added for KYP3.3 Req#103*/
	public static final String phoneAttr = "PHONE";

	public static final String NAME_LB = "NAME_FUZZY_LOWERBOUND";
	public static final String NAME_UB = "NAME_FUZZY_UPPERBOUND";
	public static final String NAME_ALG = "NAME_FUZZY_ALGORITHM";
	public static final String NAME_ER = "NAME_FUZZY_ENTITY_RES";

	
	/*Added for KYP3.3 Req#103*/
	/*START Phone number Upper and lower bound*/
	public static final String PHONE_LB = "PHONE_FUZZY_LOWERBOUND";
	public static final String PHONE_UB = "PHONE_FUZZY_UPPERBOUND";
	public static final String PHONE_ALG = "PHONE_FUZZY_ALGORITHM";
	/*END*/
	
	public static final String ADDR_LB = "ADDRESS_FUZZY_LOWERBOUND";
	public static final String ADDR_UB = "ADDRESS_FUZZY_UPPERBOUND";
	public static final String ADDR_ALG = "ADDRESS_FUZZY_ALGORITHM";
	public static final String ADDR_ER = "ADDRESS_FUZZY_ENTITY_RES";
	
	public static final String LIC_LB = "LICENSE_FUZZY_LOWERBOUND";
	public static final String LIC_UB = "LICENSE_FUZZY_UPPERBOUND";
	public static final String LIC_ALG = "LICENSE_FUZZY_ALGORITHM";
	
	public static final String DEA_LB = "DEA_FUZZY_LOWERBOUND";
	public static final String DEA_UB = "DEA_FUZZY_UPPERBOUND";
	public static final String DEA_ALG = "DEA_FUZZY_ALGORITHM";
	
	public static final String NPI_LB = "NPI_FUZZY_LOWERBOUND";
	public static final String NPI_UB = "NPI_FUZZY_UPPERBOUND";
	public static final String NPI_ALG = "NPI_FUZZY_ALGORITHM";
	
	public static final String TIN_LB = "TIN_FUZZY_LOWERBOUND";
	public static final String TIN_UB = "TIN_FUZZY_UPPERBOUND";
	public static final String TIN_ALG = "TIN_FUZZY_ALGORITHM";
	
	public static final String CLIA_LB = "CLIA_FUZZY_LOWERBOUND";
	public static final String CLIA_UB = "CLIA_FUZZY_UPPERBOUND";
	public static final String CLIA_ALG = "CLIA_FUZZY_ALGORITHM";
			
	public static final String PERS_OIG_LB = "PERS_OIGLEIE_LOWERBOUND";
	public static final String PERS_OIG_MB = "PERS_OIGLEIE_INTERBOUND";
	public static final String PERS_OIG_UB = "PERS_OIGLEIE_UPPERBOUND";
	public static final String PERS_OIG_MB_MD = "PERS_OIGLEIE_INTERBOUND_MD";
	
	public static final String PERS_EPLS_LB = "PERS_EPLS_LOWERBOUND";
	public static final String PERS_EPLS_MB = "PERS_EPLS_INTERBOUND";
	public static final String PERS_EPLS_UB = "PERS_EPLS_UPPERBOUND";
	public static final String PERS_EPLS_MB_MD = "PERS_EPLS_INTERBOUND_MD";
	
	public static final String ORG_OIG_LB = "ORG_OIGLEIE_LOWERBOUND";
	public static final String ORG_OIG_MB = "ORG_OIGLEIE_INTERBOUND";
	public static final String ORG_OIG_UB = "ORG_OIGLEIE_UPPERBOUND";
	public static final String ORG_OIG_MB_MD = "ORG_OIGLEIE_INTERBOUND_MD";

	public static final String ORG_EPLS_LB = "ORG_EPLS_LOWERBOUND";
	public static final String ORG_EPLS_MB = "ORG_EPLS_INTERBOUND";
	public static final String ORG_EPLS_UB = "ORG_EPLS_UPPERBOUND";	
	public static final String ORG_EPLS_MB_MD = "ORG_EPLS_INTERBOUND_MD";
	
	public static final String PERS_DMF_MB_MD="PERS_DMF_INTERBOUND_MD";
	
	public static final String SANDI_LB = "SANDI_FUZZY_LOWERBOUND";
	
	public static final String CORPORATE_LB = "CORPORATE_FUZZY_LOWERBOUND";
	
	public static final String FUZZY_BOUNDS = "FuzzyMatch.properties";	
	public static Properties fuzzyProps = new Properties();
	
	static
	{		
		try
		{
			InputStream inputStream = FuzzyConstants.class.getClassLoader().getResourceAsStream(FUZZY_BOUNDS);
			//InputStream inputStream = new FileInputStream(new File("E:\\pfsdomain33\\pfsdomain\\jboss-5.1.0.GA\\server\\default\\conf\\"+FUZZY_BOUNDS));
			/* uncomment owhen debugging 
			 */
			// File file = new File("E:\\FuzzyMatch.properties");
		//	InputStream inputStream = new FileInputStream(file);
			fuzzyProps.load(inputStream);
		}
		catch(MissingResourceException e)
		{
			e.printStackTrace();		
			}
		catch(IOException e)
		{
			e.printStackTrace();		
			}
		catch (Exception e)
		{
			e.printStackTrace();			
			}
	}
	
	public static String getLowerUpperBounds(String name)
	{
		return fuzzyProps.getProperty(name);
	}
	
	public static String getAlgorithm(String algName)
	{
		return fuzzyProps.getProperty(algName);
	}
}
