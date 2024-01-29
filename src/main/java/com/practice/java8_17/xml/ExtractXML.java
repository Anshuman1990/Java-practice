/**
 * 
 */
package com.practice.java8_17.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author asaha
 *
 */
public class ExtractXML extends DefaultHandler implements Constants{
	private Info infoObj;
	private Innings inningsObj;
	private Delivery deliveryObj;
	private String Data;
	private String StartElement;
	private String classifier;
	private ArrayList<String>teamsData = null;
	private ArrayList<String> umpiresData = null;
	private ArrayList<Delivery> deliveriesData = null;
	private HashMap<String, String> runsData = null;
	private HashMap<String, String> wicketsData = null;
	
	

	public void extact(String path) throws SAXException, IOException, ParserConfigurationException{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File(path),this);
	}
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		System.out.println("111111111111111"+qName);
		if(qName.equalsIgnoreCase(info)){
			infoObj = new Info();
			classifier = "info";
		}
		else if(qName.equalsIgnoreCase(innings)){
			inningsObj = new Innings();
			classifier = "innings";
		}
		
		else if(qName.equalsIgnoreCase(deliveries)){
			deliveriesData = new ArrayList<Delivery>();
		}
		
		else if(qName.equalsIgnoreCase(delivery)){
			if(deliveryObj!=null){
//				System.out.println("************************");
//				System.out.println(deliveryObj.toString());
				deliveriesData.add(deliveryObj);
				deliveryObj = new Delivery();
			}
			else{
			deliveryObj = new Delivery();
			}
		}
		else if(qName.equalsIgnoreCase(teams)){
			teamsData = new ArrayList<String>();
		}
		else if(qName.equalsIgnoreCase(umpires)){
			umpiresData = new ArrayList<String>();
		}
		else if(qName.equalsIgnoreCase(runs)){
			runsData = new HashMap<String,String>();
		}
		else if(qName.equalsIgnoreCase(wickets)){
			wicketsData = new HashMap<String,String>();
		}
		StartElement = qName;
	}

	/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
		 */
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(classifier!=null){
			switch (classifier) {
			case info:
				insertInfo(qName);
				break;
			case innings:
				insertInnings(qName);
				break;
			default:
				break;
			}
			StartElement = "";
		}
		}
		
		/* (non-Javadoc)
			 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
			 */
			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				Data = new String(ch, start, length);
			}
			
			/* (non-Javadoc)
				 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
				 */
				@Override
				public void startDocument() throws SAXException {
					
				}
				
				/* (non-Javadoc)
					 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
					 */
					@Override
					public void endDocument() throws SAXException {
						System.out.println(deliveriesData.size());
//						for(Delivery d:deliveriesData){
//							System.out.println(d.toString());
//						}
						inningsObj.setDelivery(deliveriesData);
						System.out.println("-----------INFO--------------");
						System.out.println(infoObj.toString());
						System.out.println("----------Innings---------------");
						System.out.println(inningsObj.toString());
						System.out.println("****************************");
						clearAll();
					}
					/* (non-Javadoc)
					 * @see org.xml.sax.helpers.DefaultHandler#processingInstruction(java.lang.String, java.lang.String)
					 */
					@Override
					public void processingInstruction(String target, String data) throws SAXException {
						// TODO Auto-generated method stub
						super.processingInstruction(target, data);
					}
					/* (non-Javadoc)
					 * @see org.xml.sax.helpers.DefaultHandler#endPrefixMapping(java.lang.String)
					 */
					@Override
					public void endPrefixMapping(String prefix) throws SAXException {
						// TODO Auto-generated method stub
						super.endPrefixMapping(prefix);
					}
					
				/* (non-Javadoc)
				 * @see org.xml.sax.helpers.DefaultHandler#setDocumentLocator(org.xml.sax.Locator)
				 */
				@Override
				public void setDocumentLocator(Locator locator) {
					
				}
				
				private void insertInfo(String qName){
//					System.out.println("Info-->"+qName);
					if(qName.equalsIgnoreCase(StartElement)){
						if(qName.equalsIgnoreCase(city)){
							infoObj.setCity(Data);
						}
						else if(qName.equalsIgnoreCase(date)){
							infoObj.setDate(Data);
						}
						else if(qName.equalsIgnoreCase(match_type)){
							infoObj.setMatch_type(Data);
						}
						else if(qName.equalsIgnoreCase(wickets)){
							infoObj.setWickets(Data);
						}
						else if(qName.equalsIgnoreCase(winner)){
							infoObj.setWinner(Data);
						}
						else if(qName.equalsIgnoreCase(overs)){
							int O = Integer.parseInt(Data.trim());
							infoObj.setOvers(O);
						}
						else if(qName.equalsIgnoreCase(player_of_match)){
							infoObj.setPlayerOfMatch(Data);
						}
						else if(qName.equalsIgnoreCase(team)){
							teamsData.add(Data);
							infoObj.setTeams(teamsData);
						}
						else if(qName.equalsIgnoreCase(umpire)){
							umpiresData.add(Data);
							infoObj.setUmpires(umpiresData);
						}
						}
				}
	
				private void insertInnings(String qName){
//					System.out.println("Innings--->"+qName+"\n StartElement------>"+StartElement);
//					System.out.println("--------------------------------------------------------------------");
					
					if(qName.equalsIgnoreCase(StartElement)){
						
						if(qName.equalsIgnoreCase(inningsNumber)){
							int inningNumber = Integer.parseInt(Data.trim());
							ArrayList<Integer> InningsNo = null;
							if(inningsObj.getTeam() == null){
								InningsNo = new ArrayList<Integer>();
							}
							else{
								InningsNo = inningsObj.getInningNumber();
							}
							InningsNo.add(inningNumber);
							inningsObj.setInningNumber(InningsNo);
						}
						
						else if(qName.equalsIgnoreCase(team)){
							ArrayList<String> teams = null;
							if(inningsObj.getTeam() == null){
								teams = new ArrayList<String>();
							}
							else{
								teams = inningsObj.getTeam();
							}
							teams.add(Data);
							inningsObj.setTeam(teams);
						}
						
						else if(qName.equalsIgnoreCase(over)){
//							System.out.println("over= "+Data);
							deliveryObj.setOver(Integer.parseInt(Data.trim()));
						}
						else if(qName.equalsIgnoreCase(ball)){
//							System.out.println("ball= "+Data);
							deliveryObj.setBall(Integer.parseInt(Data.trim()));
						}
						else if(qName.equalsIgnoreCase(batsman)){
							boolean chk = isInteger(Data);
							if(chk){
//								System.out.println("batsmen= "+Data);
								runsData.put(qName, Data);
								deliveryObj.setRuns(runsData);
							}
							else{
//								System.out.println("batsmen= "+Data);
								deliveryObj.setBatsman(Data);
							}
						}
						else if(qName.equalsIgnoreCase(bowler)){
//							System.out.println("bowler="+Data);
							deliveryObj.setBowler(Data);
						}
						else if(qName.equalsIgnoreCase(non_striker)){
//							System.out.println("Non Strtiker= "+Data);
							deliveryObj.setNon_striker(Data);
						}
//						else if(qName.equalsIgnoreCase(batsman)){
//							
//						}
						else if(qName.equalsIgnoreCase(extras)){
//							System.out.println("extras="+Data);
							runsData.put(qName, Data);
							deliveryObj.setRuns(runsData);
						}
						else if(qName.equalsIgnoreCase(total)){
//							System.out.println("Total="+Data);
							runsData.put(qName, Data);
							deliveryObj.setRuns(runsData);
						}
						else if(qName.equalsIgnoreCase(fielder)){
							wicketsData.put(qName, Data);
							deliveryObj.setWickets(wicketsData);
						}
						else if(qName.equalsIgnoreCase(kind)){
							wicketsData.put(qName, Data);
							deliveryObj.setWickets(wicketsData);
						}
						else if(qName.equalsIgnoreCase(player_out)){
							wicketsData.put(qName, Data);
							deliveryObj.setWickets(wicketsData);
						}
					}
				}
				
				private void clearAll(){
					if(!umpiresData.isEmpty()){
					umpiresData.clear();
					}
					else if(!teamsData.isEmpty()){
					teamsData.clear();
					}
					else if(!deliveriesData.isEmpty()){
					deliveriesData.clear();
					}
					else if(!wicketsData.isEmpty()){
					wicketsData.clear();
					}
					else if(infoObj!=null){
					infoObj = null;
					}
					else if(inningsObj!=null){
					inningsObj = null;
					}
					else if(deliveryObj!=null){
					deliveryObj = null;
					}
				}
				
				public boolean isInteger(Object obj){
					boolean chk = true;
					try{
						Integer.parseInt(obj.toString());
					}catch(NumberFormatException e){
						chk = false;
					}
					return chk;
				}
				
				
}
