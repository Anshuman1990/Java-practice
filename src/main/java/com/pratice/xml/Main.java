/**
 * 
 */
package com.xml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import com.xml.obesityXML.ExtractXml;
import org.xml.sax.SAXException;


/**
 * @author asaha
 *
 */
public class Main{
	
	
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	String path = System.getProperty("user.dir");
	path = path+"\\dataset\\obesity_patient_records_training.xml";
	System.out.println(path);
	File f = new File(path);
	File[] f_files = f.listFiles();
	long startTime = System.currentTimeMillis();
	for(File F:f_files){
		String absPath = F.getAbsolutePath();
		String fileName = F.getName();
		System.out.println("FileName="+fileName);
		ExtractXML extract = new ExtractXML();
		extract.extact(absPath);
		break;
	}
	long endTime  = System.currentTimeMillis();
	long tcons = endTime-startTime;
	System.out.println("Time Consumed= "+tcons/360+" sec");
System.out.println("Done");

}

}
