/**
 * 
 */
package com.practice.algorithm.naivebayes;

/**
 * @author asaha
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dummy {

	public static void main(String[] args) {
		String[] a = {"'a'","b"};
		int[] b = {1,2,3,4};
		Object[] c = {"'qqq'","www"};
		ArrayList<String> arr = new ArrayList<>();
		arr.add("xxx");
		arr.add("zzzz");
		
		String[] S = check_instance(a);
		display(S);
		System.out.println("------------------------------------");
		int[] I = check_instance(b);
		display(I);
		System.out.println("------------------------------------");
		Object[] O = check_instance(c);
		display(O);
		System.out.println("---------------------------------------");
		
		
	}
	
	private static <T extends Object>T  check_instance(T a){
		String regex = "[$&+:;=?@#|'<>.^*()%!-\"\\s]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		String type = "";
		T output = null;
		System.out.println(a.getClass().isArray());
		if(a.getClass().isArray()){
			type = a.getClass().getSimpleName();
			type = type.replace("[","");
			type = type.replace("]", "").trim().toUpperCase();
			System.out.println("Type= "+type);
			try{
			switch (type) {
			
			case "STRING":
				String[] S = (String[]) a;
				String S_data = Arrays.toString(S);
				S_data = S_data.replace("[", "");
				S_data = S_data.replace("]","").trim();
					matcher = pattern.matcher(S_data);
					if(matcher.find()){
						System.out.println("needs to be clean");
						String S_temp = matcher.replaceAll("");
						String[] S_split =  S_temp.split(",");
						output = (T) S_split;
					}
					else{
						output = a;
					}
				break;
				
			case "INT":
				int[] I = (int[])a;
				String I_data = Arrays.toString(I);
				I_data = I_data.replace("[", "");
				I_data = I_data.replace("]","").trim();
					matcher = pattern.matcher(I_data);
					if(matcher.find()){
						System.out.println("needs to be clean");
						String I_temp = matcher.replaceAll("");
						String[] I_split =  I_temp.split(",");
						int[] I_out = new int[I_split.length];
						for(int i=0;i<I_split.length;i++){
							I_out[i] = Integer.parseInt(I_split[i]);
						}
						output = (T) I_out;
					}
					else{
						output = a;
					}
				break;
				
				case "CHAR":
					char[] C = (char[])a;
					String C_data = Arrays.toString(C);
					C_data = C_data.replace("[", "");
					C_data = C_data.replace("]","").trim();
						matcher = pattern.matcher(C_data);
						if(matcher.find()){
							System.out.println("needs to be clean");
							String C_temp = matcher.replaceAll("");
							String[] C_split =  C_temp.split(",");
							char[] C_out = C_temp.toCharArray();
							output = (T) C_out;
						}
						else{
							output = a;
						}
					break;
				case "OBJECT":
					Object[] O = (Object[])a;
					String O_data = Arrays.toString(O);
					O_data = O_data.replace("[", "");
					O_data = O_data.replace("]","").trim();
						matcher = pattern.matcher(O_data);
						if(matcher.find()){
							System.out.println("needs to be clean");
							String O_temp = matcher.replaceAll("");
							String[] O_split =  O_temp.split(",");
							Object[] obj = O_split;
							output = (T) obj;
						}
						else{
							output = a;
						}
			default:
				break;
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		else{
//			System.out.println("false");
		}
		return output;
	}
	
	
	
	public static <T> void display(T value){
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
	
}
