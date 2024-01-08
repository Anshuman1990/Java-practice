/**
 * 
 */
package com.practice.algorithmAndDataStructure.naivebayes;

/**
 * @author asaha
 *
 */

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
private JFrame mainframe;

public Main() throws Exception {
	init();
}

public static void main(String[] args) throws Exception {
	new Main();
//	ArrayList<Integer> data = new ArrayList<Integer>();
//	data.add(11);
//	data.add(23);
//	data.add(37);
//	
//	System.out.println(calculateMean(data));
}

private void init() throws Exception{
	//"F:"+File.separator+"Dataset"+File.separator+"data.csv"
	ArrayList<String> classificationVector =null;
	Scanner scan = new Scanner(System.in);
	System.out.println("Please Provide the classification vector seperate by comma");
	String cv = scan.next();
	scan.close();
	classificationVector = new ArrayList<String>(Arrays.asList(cv.split(",")));
	System.out.println(classificationVector);
	String path = getData();
	System.out.println(path);
	NaiveBayes(path,classificationVector);
}

private String getData(){
	String filePath = "";
	JFileChooser chooser = new JFileChooser();
	mainframe = new JFrame("Please Choose the File");
	int ret_val = chooser.showOpenDialog(mainframe);
	if(ret_val == JFileChooser.APPROVE_OPTION){
		File f = chooser.getSelectedFile();
		filePath = f.getAbsolutePath();
		mainframe.dispose();
	}
	return filePath;
}

private void NaiveBayes(String path,ArrayList<String> classificationVector) throws Exception{
	long start = System.currentTimeMillis();
	NaiveBayes NB = new NaiveBayes(path,classificationVector);
	long end = System.currentTimeMillis();
	System.out.println(start+">>>"+end);
	long tc = (end-start)/1000;
	System.out.println("Time Consumed = "+tc+" sec");
	if(NB.getStatus()){
	JOptionPane.showMessageDialog(null, "Your Dataset is uploaded sucessfully!!!");
	}
}

public static double calculateMean(ArrayList<Integer> data){
	double MEAN = 0;
	int size = data.size();
	Iterator< Integer> itr = data.iterator();
	while(itr.hasNext()){
		MEAN+=itr.next();
	}
	MEAN = MEAN/size;
	return MEAN;
}

}
