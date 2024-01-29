/**
 * 
 */
package com.practice.java8_17.algorithmAndDataStructure.naivebayes;

/**
 * @author asaha
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaiveBayes implements Constants{
	private ArrayList<String> ClassificationVector = new ArrayList<String>();
	private ArrayList<String> FeatureList = null;
	private HashMap<Integer, String> constant = new HashMap<Integer,String>();
	private String Path = null;
	private Scanner scan = null;
	
	
	public NaiveBayes(String path,ArrayList<String> classificationVector) {
		this.ClassificationVector = classificationVector;
		this.Path = path;
		init();
	}
	
	private void init(){
		int count = 0;
		try{
		File f_chk = new File(Path);
		String ext = "";
		if(f_chk.isFile()){
			ext = f_chk.getName().substring(f_chk.getName().indexOf(".")+1, f_chk.getName().length());
		}
		else{
			throw new FileNotFoundException();
		}
		
		System.out.println("Extension= "+ext);
		 
		if(ext.equalsIgnoreCase(csv)){
			scan = new Scanner(new File(Path));
			
			while(scan.hasNext()){
				String line = scan.nextLine();
				extractData(line, count);
				System.out.println(count);
				count++;
			}
		}
		else if(ext.equalsIgnoreCase(txt)){
			
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			scan.close();
		}
	}
	
	public boolean getStatus(){
		boolean sta = true;
		
		return sta;
	}
	
	private void extractData(String line,int count) throws Exception{
		String[] L = null;
		if(line.contains(comma)){
			 L = line.split(comma);
		}
		else if(line.contains(Tab)){
			L = line.split(Tab);
		}
		else if(line.contains(semicolon)){
			L = line.split(semicolon);
		}
		
		L = cleanData(L);
		if(count==0){
		FeatureList = new ArrayList<String>(Arrays.asList(L));
		display(FeatureList);
		}
		else{
			display(L);
		}
	}
	
	private <T> void display(T value){
		
		if(value instanceof List)
		{
			List list = (List) value;
			Iterator itr = list.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next());
			}
		}
		
		else if(value instanceof Set){
			Set set = (Set)value;
			Iterator itr = set.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next());
			}
		}
		
		else if(value instanceof Map){
			Map map = (Map) value;
			Set keys = map.keySet();
			Iterator itr_key = keys.iterator();
			while(itr_key.hasNext()){
				Object k = itr_key.next();
				Object v = null;
				if(map.containsKey(k)){
					v = map.get(k);
				}
				System.out.println("Keys = "+k);
				System.out.println("Value = "+v);
			}
		}
		else if(value instanceof String[]){
			String[] str = (String[]) value;
			for(int i=0;i<str.length;i++){
				System.out.println(str[i]);
			}
		}
		
		else if(value instanceof int[]){
			int[] I = (int[]) value;
			for(int i=0;i<I.length;i++){
				System.out.println(I[i]);
			}
		}
		
		else if(value instanceof char[]){
			char[] I = (char[]) value;
			for(int i=0;i<I.length;i++){
				System.out.println(I[i]);
			}
		}
		
		else if(value instanceof Object[]){
			Object[] I = (Object[]) value;
			for(int i=0;i<I.length;i++){
				System.out.println(I[i]);
			}
		}
		
	}

	@Override
	public <T extends Object> T cleanData(T data) throws Exception {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		String type = "";
		T output = null;
		if(data.getClass().isArray()){
			type = data.getClass().getSimpleName();
			type = type.replace("[","");
			type = type.replace("]", "").trim().toUpperCase();
			System.out.println("Type= "+type);
			
			switch (type) {
			
			case "STRING":
				String[] S = (String[]) data;
				String S_data = Arrays.toString(S);
				S_data = S_data.replace("[", "");
				S_data = S_data.replace("]","").trim();
					matcher = pattern.matcher(S_data);
					if(matcher.find()){
						System.out.println("needs to be clean");
						String S_temp = matcher.replaceAll("");
						T S_split = (T) S_temp.split(",");
						output = S_split;
					}
					else{
						output = data;
					}
				break;
				
			case "INT":
				int[] I = (int[])data;
				String I_data = Arrays.toString(I);
				I_data = I_data.replace("[", "");
				I_data = I_data.replace("]","").trim();
					matcher = pattern.matcher(I_data);
					System.out.println(I_data+">>>"+matcher.find());
					if(matcher.find()){
						System.out.println("needs to be clean");
						String I_temp = matcher.replaceAll("");
						T I_split = (T) I_temp.split(",");
						output = I_split;
					}
					else{
						output = data;
					}
				break;
				
				case "CHAR":
					char[] C = (char[])data;
					String C_data = Arrays.toString(C);
					C_data = C_data.replace("[", "");
					C_data = C_data.replace("]","").trim();
						matcher = pattern.matcher(C_data);
						System.out.println(C_data+">>>"+matcher.find());
						if(matcher.find()){
							System.out.println("needs to be clean");
							String C_temp = matcher.replaceAll("");
							T C_split = (T) C_temp.split(",");
							output = C_split;
						}
						else{
							output = data;
						}
					break;
					
				case "OBJECT":
					Object[] O = (Object[])data;
					String O_data = Arrays.toString(O);
					O_data = O_data.replace("[", "");
					O_data = O_data.replace("]","").trim();
						matcher = pattern.matcher(O_data);
						System.out.println(O_data+">>>"+matcher.find());
						if(matcher.find()){
							System.out.println("needs to be clean");
							String O_temp = matcher.replaceAll("");
							T O_split = (T) O_temp.split(",");
							output = O_split;
						}
						else{
							output = data;
						}
						break;
						
			default:
				System.err.println("Incompatible Data Type");
				break;
			}
		}
		else{
			throw new Exception("Incompatible type Found");
		}
		return output;
	}

	private <T> void cleanup(T data){
		
	}
	
	private void probaliltyFunction(){
		
	}
	
	
}