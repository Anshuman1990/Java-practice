/**
 * 
 */
package com.document;

import java.io.File;

/**
 * @author asaha
 *
 */
public class Main {
	

	public static void main(String[] args) {
		String path = System.getProperty("user.dir")+File.separator+"doc.rtf";
		System.out.println(">>>>>>>>>"+path);
		RTFReader reader = new RTFReader();
		reader.read(path);
	}
}
