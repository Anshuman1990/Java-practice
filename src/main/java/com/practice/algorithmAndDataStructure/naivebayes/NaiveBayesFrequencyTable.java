/**
 * 
 */
package com.practice.algorithmAndDataStructure.naivebayes;

/**
 * @author asaha
 *
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public final class NaiveBayesFrequencyTable {
private String xmlPath = "";
private HashMap<Integer, String> constant = new HashMap<Integer,String>();
private Set<String> classifiers = null;
private ArrayList<String> classificationVector = new ArrayList<String>();

	public NaiveBayesFrequencyTable(String xpath,HashMap<Integer, String> c,ArrayList<String> cvector) {
		this.xmlPath = xpath;
		this.constant = c;
		this.classificationVector = cvector;
		init();
	}
	
	private void init(){
	extractAttributes();
	}
	
	private void extractAttributes(){
		try {
			String data = "";
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = df.newDocumentBuilder();
			Document doc = builder.parse(new File(xmlPath));
			
			doc.getDocumentElement().normalize();
			
			
			Set<Integer> keys = constant.keySet();
			Iterator<Integer> itr = keys.iterator();
			while(itr.hasNext()){
				int k = itr.next();
				String attributes = constant.get(k);
				String cvs = classificationVector.toString();
				
				if(cvs.contains(attributes)){
				System.out.println("--------------"+attributes+"-----------------");
				 data = doc.getElementsByTagName(attributes).item(0).getTextContent();
				extractClassifiers(data);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 private void extractClassifiers(String data){
		 data = data.replace("[", "");
		 data = data.replace("]", "");
		 String[] datas = data.split(",");
		 classifiers = new HashSet<String>(Arrays.asList(datas));
		Iterator<String> itr = classifiers.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	 }
	 
}

class Table{
	private static String data = "";
}
