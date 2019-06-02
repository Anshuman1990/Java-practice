/**
 * 
 */
package com.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


/**
 * @author asaha
 *
 */
public class Main{
	
	
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	String path = System.getProperty("user.dir");
	path = path+"//Dataset//cricsheet-xml-master//data//ODI";
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
