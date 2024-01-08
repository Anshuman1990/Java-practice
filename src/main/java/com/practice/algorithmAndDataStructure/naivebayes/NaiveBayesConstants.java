/**
 * 
 */
package com.practice.algorithmAndDataStructure.naivebayes;

/**
 * @author asaha
 *
 */
import java.util.HashMap;

public class NaiveBayesConstants {
private HashMap<Integer, String> constant = new HashMap<Integer,String>();

public NaiveBayesConstants(String[] Data) {
	setConstant(Data);
}
	private void setConstant(String[] str){
		for(int i=0;i<str.length;i++){
			String s = str[i].replace('"', ' ');
			constant.put(i, s.trim());
		}
	}

	public HashMap<Integer, String> getConstant() {
		return constant;
	}

}
